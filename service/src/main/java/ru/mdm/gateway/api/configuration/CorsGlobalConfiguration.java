package ru.mdm.gateway.api.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
@EnableWebFlux
public class CorsGlobalConfiguration implements WebFluxConfigurer {


//    @Override
//    public void addCorsMappings(CorsRegistry corsRegistry) {
//        corsRegistry.addMapping("/**")
//                .allowedOrigins("http://127.0.0.1:4999", "http://127.0.0.1:5001", "http://127.0.0.1:5002", "http://127.0.0.1:8081", "http://127.0.0.1:8082")
//                .allowedMethods("GET","POST", "OPTIONS", "HEAD")
//                .allowedHeaders("*")
//                .allowCredentials(true)
//                .maxAge(3600);
//    }

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.addAllowedOrigin("http://127.0.0.1:5173");
        corsConfig.addAllowedOrigin("http://localhost:5173");
        corsConfig.addAllowedOrigin("http://127.0.0.1:5173/dashboard");
        corsConfig.addAllowedOrigin("http://localhost:5173/dashboard");
//        corsConfig.addAllowedOrigin(vacancyServiceUrl);
        corsConfig.addAllowedMethod("*");
        corsConfig.addAllowedHeader("*");
        corsConfig.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }
}
