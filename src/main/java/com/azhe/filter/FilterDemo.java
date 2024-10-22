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
//@WebFilter("/*")
public class FilterDemo implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("doFilter...");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String url = httpServletRequest.getRequestURL().toString();
        String[] urls = {"login", "captcha", "dealLogin"};

        // 放行預設路徑
        for (String u : urls) {
            if (url.contains(u)) {
                log.info("預設路徑，放行");
                filterChain.doFilter(servletRequest, servletResponse);
                return;  // 放行後直接返回，避免重複執行
            }
        }

        log.info("不在預設路徑");

        // 檢查 session 是否存在
        HttpSession session = httpServletRequest.getSession(false); // 如果不存在則不创建新会话
        if (session == null || session.getAttribute("userID") == null) {
            log.info("服務器 session 中沒有 userID，跳轉 login 頁面 : {}{}",httpServletRequest.getContextPath(), "/login");
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login");
            return;  // 重定向後返回，避免後續邏輯執行
        }

        // 有 userID 的 session，繼續處理請求
        Object userID = session.getAttribute("userID");
        log.info("含有 userID 的 session 請求 : {} ,放行...", userID);

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);

        log.info("afterDoFilter...");
    }


    @Override
    public void destroy() {
        System.out.println("destroy...");
        Filter.super.destroy();
    }
}
