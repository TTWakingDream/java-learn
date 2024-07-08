package com.cl.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(value ="/*")
public class EncodingFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        request.setCharacterEncoding("UTF-8");
//        servletResponse.setCharacterEncoding("UTF-8");
        filterChain.doFilter(request, servletResponse);
    }
}
