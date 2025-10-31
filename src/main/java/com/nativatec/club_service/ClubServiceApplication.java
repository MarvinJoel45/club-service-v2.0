package com.nativatec.club_service;

import com.nativatec.club_service.config.OpenApiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@EnableConfigurationProperties({OpenApiProperties.class})
public class ClubServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClubServiceApplication.class, args);
    }
}