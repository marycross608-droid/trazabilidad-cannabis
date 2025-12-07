package com.cruz.trazabilidadcannabis.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Trazabilidad Cannabis")
                        .version("1.0.0")
                        .description("Sistema de seguimiento y trazabilidad en la agroindustria del cannabis")
                        .contact(new Contact()
                                .name("Maria Isabel Cruz Otero")
                                .email("isa_2789@hotmail.com")
                                .url("https://www.empresa.com")
                        )
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")
                        )
                );
    }
}