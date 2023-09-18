package br.gov.sp.fatec.recrutatech.config;

import java.util.Collections;

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
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket (DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.gov.sp.fatec.recrutatech"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaInfo());
	}
	
	private ApiInfo metaInfo() {
        return new ApiInfo(
            "Prof4tech API REST",
            "API REST da Prof4tech",
            "1.0",
            "Termos de serviço",
            new Contact("Seu Nome", "URL do Seu Site", "Seu Email"),
            "Sua Licença",
            "URL da Licença",
            Collections.emptyList()
          );
    }
    
}