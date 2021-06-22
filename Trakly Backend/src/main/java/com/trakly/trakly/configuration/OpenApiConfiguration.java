package com.trakly.trakly.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean(name="TraklyOpenApi")
    public OpenAPI TraklyOpenApi()
    {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Trakly Aplication API")
                        .description("Trakly API implemented with Spring Boot RESTFul service and documented using springdoc-openapi and OpenAPI 3.0"));
    }
}
