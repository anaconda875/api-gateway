package com.example.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class WebSecurityConfiguration {
  
  @Bean
  SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
    http
        .csrf()
        .disable()
        .authorizeExchange()
        .pathMatchers("/**")
//                .permitAll()
//                .anyExchange()
        .authenticated()
        .and()
//        .exceptionHandling()
//        .accessDeniedHandler(new HttpStatusServerAccessDeniedHandler(HttpStatus.FORBIDDEN))
//        .and()
        .oauth2ResourceServer()
        .jwt()
    ;
    return http.build();
  }
}
