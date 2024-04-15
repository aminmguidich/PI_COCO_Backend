package tn.esprit.backendpi.Entities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tn.esprit.backendpi.Service.Classes.QnAMakerAPI;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE");

    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("file:htdocs/");
    }

    @Bean
    public QnAMakerAPI qnaMakerAPI() {
        return new QnAMakerAPI(); // Ou vous pouvez initialiser la classe QnAMakerAPI avec ses dépendances nécessaires ici
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }




    }

