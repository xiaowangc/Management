package com.libo.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *  knief配置
 */
@Slf4j
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket createRestApi() {
        //
        log.info("加载swagger配置");
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //下面这个设置就是在接口的path前加上项目名
                .pathMapping("/management")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.libo.system.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("达人后台管理")
                .description("达人管理系统接口API文档")
                .license("1.0")
                .termsOfServiceUrl("https://github.com/LiBo-24/Management")
                .version("v1.0")
                .build();
    }

}

