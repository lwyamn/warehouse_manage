package com.cjlu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {



    @Bean(value = "docketPC")
    public Docket docketPC(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("PC")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cjlu.controller.pc"))
                .paths(PathSelectors.any())
                .build();
    }
    @Bean(value = "docketMobile")
    public Docket docketMobile(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("MP")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cjlu.controller.mp"))
                .paths(PathSelectors.any())
                .build();


    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact("移动在线仓储出入库平台", "", "");
        return new ApiInfo("移动在线仓储出入库平台的SwaggerAPI文档",
                "Api 文档",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
