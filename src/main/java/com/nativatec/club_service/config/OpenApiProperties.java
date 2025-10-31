package com.nativatec.club_service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "open-api")
public class OpenApiProperties {
    private String title;
    private String description;
    private String version;
    private String termsOfServiceUrl;
    private String contactName;
    private String contactUrl;
    private String contactEmail;
    private String license;
    private String licenseUrl;
    private String defaultIncludePattern;
    private String host;
    private String[] protocols;
    private boolean useDefaultResponseMessages;
}
