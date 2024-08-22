package io.github.coupon.middleware.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RoutesConfiguration
 *
 * @author Jackie Hou
 * @date 2024/8/20 19:48
 * @version 1.0
 */
@Configuration
public class RoutesConfiguration {

    @Bean
    public RouteLocator declare(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(route -> route
                .path("/gateway/coupon-customer/**")
                .filters(f -> f.stripPrefix(1))
                .uri("lb://coupon-customer-serv")

                ).route(route -> route
                .order(1)
                .path("/gateway/coupon-templalte/**")
                .filters(f -> f.stripPrefix(1))
                .uri("lb://coupon-template-serv")

                ).route(route -> route
                .path("/gateway/calculator/**")
                .filters(f -> f.stripPrefix(1))
                .uri("lb://coupon-calculation-serv")
                )
                .build();
    }
}
