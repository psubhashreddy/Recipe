package com.recipes.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Bean
	public Docket productAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.recipes.controller"))
				.paths(PathSelectors.regex("/.*"))
				.build()
				.apiInfo(metaData());
	}
	
	private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "API for Recipe Management Application",
                "Application for Recipe Management",
                "1.0",
                "Terms of service",
                new Contact("Subhash Peddyreddy", "http://localhost:8090/api/recipes", "subhash.peddyreddy@sogeti.com"),
               "Recipe Application License 1.0",
                "http://localhost:8090/api/recipes", new ArrayList<>());
        return apiInfo;
    }
	
}
