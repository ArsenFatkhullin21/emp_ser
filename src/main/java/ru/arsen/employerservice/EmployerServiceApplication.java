package ru.arsen.employerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EmployerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployerServiceApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5137") // Указать разрешённые источники
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Указать допустимые HTTP-методы
                        .allowedHeaders("*") // Указать допустимые заголовки
                        .allowCredentials(true) // Разрешить передачу cookies
                        .maxAge(3600); // Настроить время кэширования (сек.)
            }
        };
    }

}
