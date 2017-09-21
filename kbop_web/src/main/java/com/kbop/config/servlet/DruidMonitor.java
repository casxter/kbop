package com.kbop.config.servlet;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Servlet 3.0 注册 servlet filter 代替web.xml
 *
 * @author WallaceTang
 */
public class DruidMonitor implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        FilterRegistration.Dynamic wsf = servletContext.addFilter("DruidWebStatFilter", WebStatFilter.class);
        wsf.setInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        wsf.addMappingForUrlPatterns(null, false, "/*");

        ServletRegistration.Dynamic svs = servletContext.addServlet("DruidStatView", StatViewServlet.class);
        svs.addMapping("/druid/*");
    }
}
