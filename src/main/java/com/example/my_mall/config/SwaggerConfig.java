package com.example.my_mall.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


import java.util.ArrayList;

/**
 * SwaggerAPI文档的配置
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("mall项目接口文档") // 文档标题
                .description("基本的一些接口说明") // 文档基本描述
                .version("1.0") // 版本
                .license("Apache 2.0 许可") // 许可
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0") // 许可链接
                .extensions(new ArrayList<>()) // 拓展
                .build();
    }
}


