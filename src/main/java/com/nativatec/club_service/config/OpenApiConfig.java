package com.nativatec.club_service.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class OpenApiConfig {

    private final OpenApiProperties properties;

    public OpenApiConfig(OpenApiProperties properties) {
        this.properties = properties;
    }

//    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title(properties.getTitle())
                        .description(properties.getDescription())
//                        .termsOfService(properties.getTermsOfServiceUrl())
//                        .contact(new Contact().email(properties.getContactEmail()))
//                        .license(new License().name(properties.getLicense()))
                        .version(properties.getVersion())
                );
    }
}
