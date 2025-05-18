package ru.mdm.gateway.api.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
//@ConfigurationProperties("mdm.registry.service")
public class RegistryProperties {

    private String uri;
    private List<String> predicates;
    private List<String> filters;
    private String name;
}
