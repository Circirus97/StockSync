package com.riwi.StockSync.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "StockSync",
                version = "1.0",
                description = "Sistema de gestión de inventarios y facturación para tiendas,con la capacidad de administrar múltiples tiendas de manera simultánea y proporcionar funcionalidades diferenciadas para empleados y administradores."
        )
)
public class OpenApiConfig {
}
