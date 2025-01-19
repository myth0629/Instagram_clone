package com.example.instagram_clone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
// Security 활성화
@Configuration
public class SecurityConfig {
    @Bean
    public DefaultSecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // url에 권한 부여
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests.requestMatchers(
                                AntPathRequestMatcher.antMatcher("/"),
                                AntPathRequestMatcher.antMatcher("/user/**"),
                                AntPathRequestMatcher.antMatcher("/image/**"),
                                AntPathRequestMatcher.antMatcher("/subscribe/**"),
                                AntPathRequestMatcher.antMatcher("/comment/**")
                        ).authenticated().anyRequest().permitAll()
                ).formLogin(formConfig ->
                        formConfig.loginPage("/auth/login")
                                .defaultSuccessUrl("/")).build();
    }
}
