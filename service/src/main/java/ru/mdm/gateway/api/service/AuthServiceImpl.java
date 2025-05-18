package ru.mdm.gateway.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import ru.mdm.gateway.api.configuration.KeycloakConfig;

/**
 * Реализация сервиса аутентификации.
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final WebClient webClient;
    private final KeycloakConfig keycloakConfig;

    @Override
    public Mono<Object> auth(String authorization, ServerWebExchange serverWebExchange) {
        return serverWebExchange.getFormData()
                .doOnSuccess(map -> map.add("client_secret", keycloakConfig.getClientSecret()))
                .flatMap(map -> webClient.post()
                        .uri(keycloakConfig.getTokenUri())
                        .body(BodyInserters.fromFormData(map))
                        .header(HttpHeaders.AUTHORIZATION, authorization)
                        .retrieve()
                        .bodyToMono(Object.class));
    }

    @Override
    public Mono<String> greet(Authentication authentication) {
        return Mono.just("Hello, " + authentication.getName() + "!");
    }
}
