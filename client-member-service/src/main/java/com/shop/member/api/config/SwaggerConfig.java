package com.shop.member.api.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Ecommerce Client Member API")
                .contact(new Contact("", "", ""))
                .build();
    }

    @Bean
    public Docket api() {
        //Authentication header 처리를 위해 사용
        List<Parameter> global = new ArrayList<>();
        global.add(new ParameterBuilder().name("Authorization").
                description("Access Token").parameterType("header").
                required(false).modelRef(new ModelRef("string")).build());

        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(global)
                .select()
                .apis(Predicates.not(RequestHandlerSelectors.
                        basePackage("org.springframework.boot")))
                .paths(PathSelectors.any()).build()
                .apiInfo(apiInfo());
    }
}
