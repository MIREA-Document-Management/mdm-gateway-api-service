package ru.mdm.gateway.api.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("mdm.keycloak")
public class KeycloakConfig {

    private String url;
    private String jwkSetUri;
    private String clientSecret;
    private String tokenUri;
}
