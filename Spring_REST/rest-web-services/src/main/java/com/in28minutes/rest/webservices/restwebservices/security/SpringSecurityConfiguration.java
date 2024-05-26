package com.in28minutes.rest.webservices.restwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        ///1) All the request should be authenticated
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        ///2) Enable HTTP Basic authentication for REST APIs
        http.httpBasic(Customizer.withDefaults());
        ///3) Disable CSRF
        http.csrf().disable();

        return http.build();
    }
}
