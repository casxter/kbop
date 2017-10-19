package com.kbop.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WallaceTang
 */
@Configuration
public class WebConfig {
    @Bean
    public ServletRegistrationBean druidstatViewServlet() {
        ServletRegistrationBean srb = new ServletRegistrationBean();

        srb.setServlet(new StatViewServlet());
        srb.setName("druidstatViewServlet");
        srb.addUrlMappings("/druid/*");
        srb.setOrder(1);

        srb.addInitParameter("loginUsername", "kbop");
        srb.addInitParameter("loginPassword", "980c9b2d5336f2bf");
        srb.addInitParameter("resetEnable", "false");

        return srb;
    }

    @Bean
    public FilterRegistrationBean druidwebStatFilter() {
        FilterRegistrationBean frb = new FilterRegistrationBean();

        frb.setFilter(new WebStatFilter());
        frb.setName("druidwebStatFilter");
        frb.addUrlPatterns("/*");
        frb.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        frb.setOrder(1);

        return frb;
    }

//    @Bean
//    public FilterRegistrationBean xssFilter(){
//        FilterRegistrationBean frb = new FilterRegistrationBean();
//
//        frb.setFilter(new XssFilter());
//        frb.setName("xssFilter");
//        frb.addUrlPatterns("/*");
//
//        return frb;
//    }
}
