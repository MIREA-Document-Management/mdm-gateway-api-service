package ru.mdm.gateway.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import ru.mdm.gateway.api.rest.AuthRestApi;
import ru.mdm.gateway.api.service.AuthService;

/**
 * Контроллер аутентификации.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(AuthRestApi.BASE_URI)
public class AuthController implements AuthRestApi {

    private final AuthService authServiceImpl;

    @Override
    public Mono<Object> auth(String authorization, ServerWebExchange serverWebExchange) {
        return authServiceImpl.auth(authorization, serverWebExchange);
    }

    @Override
    public Mono<String> greet(Authentication authentication) {
        return authServiceImpl.greet(authentication);
    }
}
