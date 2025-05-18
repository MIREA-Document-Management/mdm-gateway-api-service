package ru.mdm.gateway.api.model.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Модель маршрутизации приложения.
 */
@Data
@Builder
public class RouteDto {

    private String id;
    private String uri;
    private String path;
    private String setFilterPath;
    private Integer stripPrefix;
}
