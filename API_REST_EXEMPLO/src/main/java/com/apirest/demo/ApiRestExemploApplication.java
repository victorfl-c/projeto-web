package com.apirest.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ApiRestExemploApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestExemploApplication.class, args);
	}
	
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/listar").allowedOrigins("*");
				registry.addMapping("/cadastrar").allowedOrigins("*");
				registry.addMapping("/get").allowedOrigins("*");
				registry.addMapping("/atualizar").allowedOrigins("*");
				registry.addMapping("/remover").allowedOrigins("*");
			}
		};
	}

}
