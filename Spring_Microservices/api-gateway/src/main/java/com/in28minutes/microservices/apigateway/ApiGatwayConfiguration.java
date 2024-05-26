package com.in28minutes.microservices.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatwayConfiguration {

    ////we create a custom bean for RouteLocator and To be able to create a RouteLocator we need RouteLocatorBuilder.
    ////Using Builder we will be able to customize the routes whcih we want to use.
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        //return builder.routes().build(); /// when we are not customizing any routes.
        return builder.routes()
                //We are here creating a simple route function, If a request is "/get" then we want to redirect to below URI.
                .route(p -> p.path("/get")
                        ////We can add request headers and parameters before redirecting to url.
                        .filters(f -> f.addRequestHeader("MyHeader", "MyURI")
                                       .addRequestParameter("Param", "MyValue"))
                        .uri("http://httpbin.org:80"))
                ///Configure currency exchange service to redirect to naming server with load balancer.
                .route(p -> p.path("/currency-exchange/**")
                             .uri("lb://currency-exchange"))
                ///Configure currency conversion service to redirect to naming server with load balancer.
                .route(p -> p.path("/currency-conversion/**")
                        .uri("lb://currency-conversion"))
                .route(p -> p.path("/currency-conversion-feign/**")
                        .uri("lb://currency-conversion"))
                ///Configure a new url and redirect to currency conversion feign service
                .route(p -> p.path("/currency-conversion-new/**")
                        .filters(f -> f.rewritePath("/currency-conversion-new/(?<segment>.*)",
                                "/currency-conversion-feign/${segment}"))
                        .uri("lb://currency-conversion"))
                .build();
    }
}
