package com.evertonluissp.bravichallenge.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    @Primary
    public SwaggerResourcesProvider swaggerResourcesProvider() {
        return () -> {
            var resource = new SwaggerResource();
            resource.setLocation("/swagger.yaml");

            return List.of(resource);
        };
    }

}