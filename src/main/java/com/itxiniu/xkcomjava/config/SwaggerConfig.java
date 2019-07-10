package com.itxiniu.xkcomjava.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String apiPath = "/api/**";
    @Value("${app.version}")
    private String version;
    @Value("${spring.application.name}")
    private String serverName;

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.ant(apiPath))
                .build();

    }

    private ApiInfo apiInfo(){
        return new ApiInfo(serverName,serverName+" api文档",version,null,new Contact("Xia Gen","https://github.com/githubkyr/xkcomjava","704863664@qq.com"),"Apache License Version 2.0","https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
    }

}
