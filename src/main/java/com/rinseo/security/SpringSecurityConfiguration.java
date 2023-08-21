package com.rinseo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception {
        // 1. All request should be authenticated
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());
        // 2. If not, redirect to login page
        http.httpBasic(withDefaults());
        // 3. Disable CSRF
        http.csrf(csrf -> csrf.disable());

        return http.build();

    }
}
