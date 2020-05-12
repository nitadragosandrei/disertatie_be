package com.example.homework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "OPTIONS", "PUT", "PATCH", "DELETE")
                .allowedHeaders("Content-Type", "X-Email", "Accept", "Origin", "Access-Control-Request-Method",
                        "Access-Control-Request-Headers", "Authorization") //, "Access-Control-Allow-Headers")
                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
                .allowCredentials(true)
                .maxAge(3600);
    }
}