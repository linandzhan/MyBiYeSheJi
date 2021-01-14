package com.zixishi.zhanwei.config.authorization.interceptor;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


//@Order(1)
//@WebFilter(filterName="firstFilter", urlPatterns="/*")
public class FilterChainImpl implements Filter {

    @Resource
    private AuthorizationInterceptor authorizationInterceptor;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("asdasdsd");
    }
}
