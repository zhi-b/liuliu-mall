package com.liuliu.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//配置类
@Configuration
//启用Swagger的配置
@EnableSwagger2
//配置扫描的基础包
@ComponentScan(basePackages = "com.liuliu.controller")
public class SwaggerConfig {
    //在构建文档的时候 只显示添加了@Api注解的类
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("溜溜商城API接口文档")
                .description("溜溜商城API接口文档，及相关接口的说明")
                .version("1.0.0")
                .contact(new Contact("lanqiao","http://www/lanqiao.org","tom@126.com"))
                .build();
    }
}
