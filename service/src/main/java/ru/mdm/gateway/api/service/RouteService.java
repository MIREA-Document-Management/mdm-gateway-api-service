package ru.mdm.gateway.api.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.SetPathGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.StripPrefixGatewayFilterFactory;
//import org.springframework.cloud.gateway.filter.factory.TokenRelayGatewayFilterFactory;
import org.springframework.cloud.gateway.handler.predicate.PathRoutePredicateFactory;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import ru.mdm.gateway.api.configuration.RegistryProperties;
import ru.mdm.gateway.api.model.dto.RouteDto;
//import ru.mdm.registry.client.RegistryClient;
//import ru.mdm.registry.model.InstanceDto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Slf4j
@Service
@RequiredArgsConstructor
public class RouteService {

    private final ApplicationEventPublisher applicationEventPublisher;
//    private final RegistryClient registryClient;
    private final RegistryProperties registryProperties;
//    private final TokenRelayGatewayFilterFactory tokenRelayGatewayFilterFactory;


//    @PostConstruct
//    void initRoutes() {
//        // Получение всех экземпляров из реестра
//        registryClient.getServices()
//                // Добавление ко всем экземплярам экзмепляр реестра сервисов
//                .concatWithValues(getRegistryInstanceDto())
//                // Смаппить в модель маршрута для Spring Cloud Gateway
//                .map(this::mapToRouteDto)
//                .map(this::buildRoute)
//                // Опубликовать внутреннее событие, чтобы Cloud Gateway обновил маршруты
//                .doOnNext(route -> applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this)));
//    }

//    private RouteDto mapToRouteDto(InstanceDto application) {
//        var route = application.getRoute();
//        var routeDtoBuilder = RouteDto.builder();
//        routeDtoBuilder.id(application.getName());
//
//        List<String> filters = route.getFilters();
//        String path = route.getPredicates().stream()
//                .filter(str -> str.startsWith("Path="))
//                .map(string -> string.substring(string.indexOf("=") + 1))
//                .findFirst().orElseThrow();
//        routeDtoBuilder.path(path);
//        if (!CollectionUtils.isEmpty(filters)) {
//            String setFilterPath = filters.stream()
//                    .filter(str -> str.startsWith("SetPath="))
//                    .map(string -> string.substring(string.indexOf("=") + 1))
//                    .findFirst().orElse("");
//            if (!setFilterPath.isBlank()) {
//                routeDtoBuilder.setFilterPath(setFilterPath);
//            }
//
//            String stripPrefix = filters.stream()
//                    .filter(str -> str.startsWith("StripPrefix="))
//                    .map(string -> string.substring(string.indexOf("=") + 1))
//                    .findFirst().orElse("");
//            Integer intPrefix = Integer.parseInt(stripPrefix);
//            if (!stripPrefix.isBlank()) {
//                routeDtoBuilder.stripPrefix(intPrefix);
//            }
//        }
//        return routeDtoBuilder
//                .uri(route.getUri())
//                .build();
//    }
//
//    private InstanceDto getRegistryInstanceDto() {
//        var instance = new InstanceDto();
//        instance.setName(registryProperties.getName());
//
//        var route = new ru.mdm.registry.model.RouteDto();
//        route.setUri(registryProperties.getUri());
//        route.setPredicates(registryProperties.getPredicates());
//        route.setFilters(registryProperties.getFilters());
//
//        instance.setRoute(route);
//        return instance;
//    }
//
//    private Route buildRoute(RouteDto routeDto) {
//        Route.AsyncBuilder builder = Route.async().id(routeDto.getId()).uri(routeDto.getUri())
//                .predicate(createPredicate(routeDto));
//
//        if (routeDto.getSetFilterPath() != null || routeDto.getStripPrefix() != null) {
//            List<GatewayFilter> filters = createFilters(routeDto);
//            for (int order = 0; order < filters.size(); order++) {
//                builder.filter(new OrderedGatewayFilter(filters.get(order), order));
//            }
//        }
//
//        return builder.build();
//    }
//
//    private Predicate<ServerWebExchange> createPredicate(RouteDto routeDto) {
//        return new PathRoutePredicateFactory()
//                .apply(config -> config.setMatchTrailingSlash(true).setPatterns(List.of(routeDto.getPath())));
//    }
//
//    private List<GatewayFilter> createFilters(RouteDto routeDto) {
//        List<GatewayFilter> filters = new ArrayList<>();
//
////        filters.add(tokenRelayGatewayFilterFactory.apply());
//
//        if (routeDto.getSetFilterPath() != null) {
//            filters.add(new SetPathGatewayFilterFactory().apply(config -> config.setTemplate(routeDto.getSetFilterPath())));
//        }
//        if (routeDto.getStripPrefix() != null) {
//            filters.add(new StripPrefixGatewayFilterFactory().apply(config -> config.setParts(routeDto.getStripPrefix())));
//        }
//
//        return filters;
//    }
}
