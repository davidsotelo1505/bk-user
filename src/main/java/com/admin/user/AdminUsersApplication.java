package com.admin.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AdminUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminUsersApplication.class, args);
	}
	

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.admin.user.controller"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact("Eyder Ascuntar Rosales", "https://www.virginmobile.co",
				"david.sotelo@virginmobilecolombia.com");
		return new ApiInfoBuilder().title("API RESTful Gestión Acceso y Seguridad").description(
				"Esta api describe la funcionalidad para los servicios tipo Rest expuestos para gestionar la Autenticación y Autorización de los sistemas relacionados de adminUser")
				.version("1.0.0").license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
				.contact(contact).build();
	}

}
