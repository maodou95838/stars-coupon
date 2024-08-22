package io.github.coupon.middleware;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;

/**
 * RoutesConfiguration
 *
 * @author Jackie Hou
 * @date 2024/8/15 22:38
 * @version 1.0
 */
@Configuration
public class RoutesConfiguration {

    public RouteLocator declare(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(route -> route
                      .path("/gateway/coupon-customer/**")
                      .filters(f -> f.stripPrefix(1))
                      .uri("lb://coupon-customer-serv")
                ).build();
    }
}
