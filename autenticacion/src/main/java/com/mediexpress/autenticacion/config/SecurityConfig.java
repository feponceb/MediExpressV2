package com.mediexpress.autenticacion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/log/registro", "/api/log/login").permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic(httpBasic -> {});  // forma recomendada para httpBasic en la nueva sintaxis

        return http.build();
    }
}
