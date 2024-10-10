package com.pmh.org.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
@Slf4j
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("지나갈 때 호출되는 메서드");
        log.info("test : {}", servletRequest.getParameter("test"));

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("필터 생성될 때 호출되는 메서드");
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        log.info("필터 파괴될 때 호출되는 메서드");
        Filter.super.destroy();
    }
}
