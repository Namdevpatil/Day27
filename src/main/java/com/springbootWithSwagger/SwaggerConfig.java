package com.springbootWithSwagger;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig 
{
	
	public Docket postsApi() 
	{
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
		
	}
	
	private Predicate<String> postPaths(){
		return or(regex("/api/posts.*"),regex("/sms/students.*"));		
	}
	
	private ApiInfo apiInfo() //optional
	{
		return new ApiInfoBuilder().title("XYZ Private Limited.")
				.description("Swagger API reference for developers")
				.termsOfServiceUrl("http://www.xyz.com")
				.contact("xyz.net@gmail.com")
				.license("XYZ Private Limited.")
				.licenseUrl("xyz@info.com")
				.version("4.0")
				.build();
	}

}
