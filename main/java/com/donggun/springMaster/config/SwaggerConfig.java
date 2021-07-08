package com.donggun.springMaster.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.donggun.springMaster.controller.RestController"))
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/");
	}

	public ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Spring Master")
				.version("1.0.0-SNAPSHOT")
				.description("Spring Master API")
				.build();
	}
	
	// Resource Handler에 Swagger UI 등록하기 
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/"); 
		
		registry.addResourceHandler("/webjars/**") 
				.addResourceLocations("classpath:/META-INF/resources/webjars/");

	}

}
