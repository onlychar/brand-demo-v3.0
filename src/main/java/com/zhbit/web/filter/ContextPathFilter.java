package com.zhbit.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("*.jsp")
public class ContextPathFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        String contextPath = req.getContextPath( );
        ServletContext servletContext = request.getServletContext( );
        servletContext.setAttribute("contextPath",contextPath);
        chain.doFilter(request, response);
//        System.out.println("success set contextPath in request " );
    }
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }
}
