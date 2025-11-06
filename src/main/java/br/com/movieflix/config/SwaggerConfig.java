package br.com.movieflix.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer"
)
public class SwaggerConfig {

    public OpenAPI getOpenAPI(){
        Contact contact = new Contact();
        contact.name("Matheus");
        contact.email("matheusferreirasjc@gmail.com");
        Info info = new Info();
        info.title("MovieFlix");
        info.description("Aplicação para gerenciamento de catálogo de filmes");
        info.contact(contact);

        return new OpenAPI().info(info);
    }
}
