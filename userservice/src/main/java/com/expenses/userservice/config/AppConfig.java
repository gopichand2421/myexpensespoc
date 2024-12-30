package com.expenses.userservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class AppConfig {

    //Swagger configuration
    @Bean
    public OpenAPI swaggerConfig(){
        Contact contact = new Contact();
        contact.setEmail("kalyangopichand57@gmail.com");
        contact.setName("gopichand");
        Info info = new Info()
                .title("User management serivce")
                .version("1.0")
                .contact(contact);
        return new OpenAPI().info(info);

    }
}
