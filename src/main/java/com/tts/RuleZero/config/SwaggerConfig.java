package com.tts.RuleZero.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

@Configuration
public class SwaggerConfig {

    public static final String TAG_V1 = "deck-api-version-1";

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tts.RuleZero"))
                .paths(PathSelectors.any())
                .build()
//                .tags(new Tag(TAG_USER_CONTROLLER, "Operations pertaining to User management"))
                .tags(new Tag(TAG_V1, "Operations pertaining to Deck management, API Version 1"))
                .apiInfo(buildApiInfo())
                ;
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("Deck API")
                .description("REST API for interacting with Decks")
                .version("1.0.0")
                .contact(new Contact("Joshua Luppes", "www.joshualuppes.com", "joshua.luppes@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }

    @Bean
    UiConfiguration buildUiConfig() {
        return UiConfigurationBuilder.builder()
                .docExpansion(DocExpansion.LIST)
                .build();
    }
}