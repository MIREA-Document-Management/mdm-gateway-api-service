package ru.mdm.gateway.api.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Сервис аутентификации.
 */
public interface AuthService {

    /**
     * Авторизоваться.
     *
     * @param authorization уже существующий токен авторизации
     * @param serverWebExchange данные запроса
     * @return параметры успешной авторизации
     */
    Mono<Object> auth(String authorization, ServerWebExchange serverWebExchange);

    /**
     * Проверка авторизации.
     *
     * @param authentication данные авторизации
     * @return приветственное сообщение
     */
    Mono<String> greet(Authentication authentication);
}
