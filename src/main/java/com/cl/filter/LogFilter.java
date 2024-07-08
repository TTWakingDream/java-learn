package com.cl.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;


@WebFilter("/*")
public class LogFilter implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("path : "+ ((HttpServletRequest)servletRequest).getRequestURI().toString());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
