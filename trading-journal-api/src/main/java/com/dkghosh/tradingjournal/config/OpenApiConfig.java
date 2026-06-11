package com.dkghosh.tradingjournal.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Trading Journal API",
                version = "v1.0",
                description = """
                        REST API for managing trades, risk analysis,
                        emotional discipline tracking, and trading performance.
                        Built with Spring Boot, PostgreSQL, Docker, Kafka,
                        Jenkins, Kubernetes, and AWS.
                        """,
                contact = @Contact(
                        name = "Dipak Ghosh",
                        email = "durja1008@gmail.com"
                ),
                license = @License(
                        name = "MIT License"
                )
        )
)
public class OpenApiConfig {
}