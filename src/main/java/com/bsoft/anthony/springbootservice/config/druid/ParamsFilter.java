package com.bsoft.anthony.springbootservice.config.druid;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//import org.apache.catalina.servlet4preview.http.HttpServletRequest;

/**
 * 创建日期 : 2019/10/24
 * 创建人 : 赵太行
 */
public class ParamsFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        ParamsRequestWrapper requestWrapper = new ParamsRequestWrapper(httpRequest);
        filterChain.doFilter(requestWrapper, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
