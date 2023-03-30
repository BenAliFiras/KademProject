package tn.agena3000.edi.kademproject.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

        @Bean
        public OpenAPI springShopOpenAPI() {
            return new OpenAPI()
                    .info(infoAPI());

        }
        public Info infoAPI() {
            return new Info().title("KademProject")
                    .description("TP étude de cas")
                    .contact(contactAPI());

        }
        public Contact contactAPI() {
            Contact contact = new Contact().name("Firas")
                    .email("firas.benali@esprit.tn")
                    .url("https://www.linkedin.com/in/**********/");
            return contact;
        }
}
