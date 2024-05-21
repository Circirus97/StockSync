package com.riwi.StockSync.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "StockSync",
                version = "1.0",
                description = "Inventory and billing management system for stores, with the ability to manage multiple stores simultaneously and provide differentiated functionalities for employees and administrators."
        )
)
public class OpenApiConfig {
}
