package com.kbop.config;

import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import java.nio.charset.StandardCharsets;

/**
 * Created by WallaceTang on 2017/4/28.
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        //映射url路径
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding(StandardCharsets.UTF_8.name());
        characterEncodingFilter.setForceEncoding(true);

        WebStatFilter wsf = new WebStatFilter();

        return new Filter[]{characterEncodingFilter};
    }


}
