package ru.mdm.gateway.api.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * REST-API для аутентификации.
 */
public interface AuthRestApi {

    String BASE_URI = "/api/v1";

    @Operation(summary = "Авторизоваться в системе",
            description = "Авторизоваться в системе",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Успешно",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Object.class))),
                    @ApiResponse(responseCode = "400", description = "Неверный формат переданных значений",
                            content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера",
                            content = @Content(schema = @Schema(hidden = true)))
            })
    @PostMapping(value = "/auth", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Mono<Object> auth(
            @RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String authorization,
            ServerWebExchange serverWebExchange
    );

    @Operation(summary = "Проверка авторизации",
            description = "Проверить, авторизован ли пользователь",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Приветственное сообщение",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = String.class))),
                    @ApiResponse(responseCode = "400", description = "Неверный формат переданных значений",
                            content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера",
                            content = @Content(schema = @Schema(hidden = true)))
            })
    @GetMapping("/greet")
    Mono<String> greet(Authentication authentication);
}
