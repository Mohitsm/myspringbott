package com.employee.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer{
	 public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
                    .allowedOriginPatterns("http://localhost:5173","http://localhost:8081,","https://acetaffworld.com")
	                .allowedMethods("GET", "POST", "PUT", "DELETE")
	                .allowedHeaders("Content-Type","Authorization")
	                .allowCredentials(true);
//	                .maxAge(3600); // Optional: set max age for CORS preflight requests
	    }
	 

}
