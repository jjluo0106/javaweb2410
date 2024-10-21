package com.azhe.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Slf4j
// 過濾器
@WebFilter("/*")
public class FilterDemo implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter...");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String url = httpServletRequest.getRequestURL().toString();
        String[] urls = {"login","captcha"};

        for (String u : urls) {
            if(url.contains(u)){
                log.info("預設路徑，放行");
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }



        // 将 ServletRequest 转换为 HttpServletRequest
        if (servletRequest instanceof HttpServletRequest) {

            // 获取 HttpSession
            HttpSession session = httpServletRequest.getSession(false); // 如果不存在则不创建新会话

            // 检查是否存在 session，并打印 session 中的内容
            if (session.getAttribute("userID") != null) {
                // 假设 session 中存储了一个名为 "user" 的属性
                Object userID = session.getAttribute("userID");
                log.info("含有 userID 的 session 請求 : " + userID);
            } else {
               log.info("服務器session中沒有 userID，跳轉login頁面");
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login");
            }
        }

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("afterDoFilter...");
    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
        Filter.super.destroy();
    }
}
