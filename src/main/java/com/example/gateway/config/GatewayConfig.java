package com.example.gateway.config;

import com.example.gateway.filter.HeaderAdder;
import com.example.gateway.filter.LogFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()

                .route("USER-SERVICE", r -> r.path("/api/v1/user/**")
                        .filters(f -> f.filter(new HeaderAdder())
                                .filter(new LogFilter()))
                        .uri("lb://USER-SERVICE"))

                .route("AUTH-SERVICE", r -> r.path("/api/v1/auth/**")
                        .filters(f -> f.filter(new HeaderAdder())
                                .filter(new LogFilter()))
                        .uri("lb://AUTH-SERVICE"))

                .route("PRODUCT-SERVICE", r -> r.path("/api/v1/product/**")
                        .filters(f -> f.filter(new HeaderAdder())
                                .filter(new LogFilter()))
                        .uri("lb://PRODUCT-SERVICE"))

                .route("ORDER-SERVICE", r -> r.path("/api/v1/order/**")
                        .filters(f -> f.filter(new HeaderAdder())
                                .filter(new LogFilter()))
                        .uri("lb://ORDER-SERVICE"))


                .build();
    }
}

