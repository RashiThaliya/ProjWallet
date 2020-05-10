package com.example.gate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration 	
public class WalletConfiguration {
	
		@Bean
		public WebMvcConfigurer corsConfigurer() {
			return new  WebMvcConfigurer() {
				@Override
				public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping("/**")
					.allowedMethods("GET","POST","PUT","DELETE")
					.allowedHeaders("*")
					.allowedOrigins("http://localhost:4200")
					.allowCredentials(false).maxAge(3600);
					
				}
			};
	}
	
}
