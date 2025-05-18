package ru.mdm.gateway.api.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class GatewaySecurityConfig {

    private static final String[] PUBLIC_URIS = {
            "/api/v1/auth"
    };

//    private final KeycloakConfig keycloakConfig;
//
//    @Bean
//    @Primary
//    SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
//        http
//                .authorizeExchange(authorize -> authorize
//                        .pathMatchers(PUBLIC_URIS).permitAll()
//                        .anyExchange().authenticated()
//                )
//                .csrf(ServerHttpSecurity.CsrfSpec::disable)
//                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
//
//        return http.build();
//    }
//
//    @Bean
//    NimbusReactiveJwtDecoder jwtDecoder() {
//        var jwkSetUri = keycloakConfig.getJwkSetUri();
//        return NimbusReactiveJwtDecoder
//                .withJwkSetUri(jwkSetUri)
//                .build();
//    }
//
//    @Bean
//    public ReactiveOAuth2AuthorizedClientManager authorizedClientManager(
//            ReactiveClientRegistrationRepository clientRegistrationRepository,
//            ReactiveOAuth2AuthorizedClientService authorizedClientService) {
//
//        ReactiveOAuth2AuthorizedClientProvider authorizedClientProvider =
//                ReactiveOAuth2AuthorizedClientProviderBuilder.builder()
//                        .clientCredentials()
//                        .build();
//
//        var authorizedClientManager = new AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager(
//                clientRegistrationRepository, authorizedClientService);
//        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);
//
//        return authorizedClientManager;
//    }
}
