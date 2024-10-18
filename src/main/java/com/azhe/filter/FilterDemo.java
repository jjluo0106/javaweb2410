package com.azhe.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@WebFilter("/*")
public class FilterDemo implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter...");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
