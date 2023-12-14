package com.consumer.consumersocket.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration

public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.consumer.consumersocket.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
//import io.swagger.models.auth.In;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpHeaders;
//
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.ApiKey;
//import springfox.documentation.service.AuthorizationScope;
//import springfox.documentation.service.SecurityReference;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;

//@Configuration
//@EnableSwagger2

//public class SwaggerConfig extends WebMvcConfigurationSupport {
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//                .securitySchemes(Arrays.asList(apiKey()))
//                .securityContexts(Collections.singletonList(securityContext()))
//                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Swagger API")
//                .description("API documentation with Swagger")
//                .version("1.0")
//                .build();
//    }
//
//    private ApiKey apiKey() {
//        return new ApiKey("JWT", HttpHeaders.AUTHORIZATION, In.HEADER.name());
//    }
//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder().securityReferences(defaultAuth())
//                .forPaths(PathSelectors.regex("/.*"))
//                .build();
//    }
//
//    private List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return Collections.singletonList(new SecurityReference("JWT", authorizationScopes));
//    }
//}

//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.info.Info;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpHeaders;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.ApiKey;
//
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//@Configuration
//@OpenAPIDefinition(info = @Info(title = "Swagger API", version = "1.0", description = "API documentation with Swagger"))
//public class SwaggerConfig {
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//                .securitySchemes(Arrays.asList(apiKey()))
//                .securityContexts(Collections.singletonList(securityContext()))
//                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfo("Swagger API", "API documentation with Swagger", "1.0", null, null, null, null, Collections.emptyList());
//    }
//
//    private ApiKey apiKey() {
//        return new ApiKey("JWT", HttpHeaders.AUTHORIZATION, io.swagger.v3.oas.annotations.enums.In.HEADER.name());
//    }
//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder().securityReferences(defaultAuth())
//                .forPaths(PathSelectors.regex("/.*"))
//                .build();
//    }
//
//    private List<io.swagger.v3.oas.annotations.security.SecurityReference> defaultAuth() {
//        io.swagger.v3.oas.annotations.security.SecurityReference securityReference =
//                new io.swagger.v3.oas.annotations.security.SecurityReference("JWT",
//                        new io.swagger.v3.oas.annotations.security.SecurityScope[]{new io.swagger.v3.oas.annotations.security.SecurityScope("global", "accessEverything")});
//        return Collections.singletonList(securityReference);
//    }
//}
//
