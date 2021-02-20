package com.xp.note.config;

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
 * @author cs
 * Create in 2019/8/30
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {
    private final static String BASE_PACKAGE = "com.xp.note";
    private final static String SWAGGER_TITLE = "数据采集服务RESTful APIs";
    private final static String VERSION = "1.0.0";
    private final static String DESCRIPTION = "HTTP方法、参数说明，以及模拟实时调用结果展示，使用方法自行参照Swagger2文档";
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                //配置说明
                .apiInfo(apiInfo())
                .select()
                //拦截的包
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                //拦截的接口路径,也可以指定，如：regex("/v1/user/.*")
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(SWAGGER_TITLE)
                .description(DESCRIPTION)
                .version(VERSION)
                .build();
    }
}
