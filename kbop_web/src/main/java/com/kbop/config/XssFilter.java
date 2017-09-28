package com.kbop.config;

import com.kbop.util.XssHttpWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by TWJ on 2016-10-18.
 */

/**
 * Xss保护过滤器
 *
 * @author storezhang
 */
//@WebFilter(filterName = "xssFilter", urlPatterns = "/*")
public class XssFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Xss filter inited!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        XssHttpWrapper xssRequest = new XssHttpWrapper((HttpServletRequest) request);
        System.out.println("Xss filter worked!");
        chain.doFilter(xssRequest, response);
    }

    @Override
    public void destroy() {
        System.out.println("Xss filter destroyed!");
    }
}
