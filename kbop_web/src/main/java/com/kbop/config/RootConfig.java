package com.kbop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.nio.charset.StandardCharsets;


@Configuration
@ComponentScan(basePackages = {"com.kbop"})
public class RootConfig {

    @Bean
    //bean 的id用方法名，需要一致
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver cmr = new CommonsMultipartResolver();
        //128mb per file
        cmr.setMaxUploadSizePerFile(134217728);
        cmr.setDefaultEncoding(StandardCharsets.UTF_8.name());
        return cmr;
    }

}
