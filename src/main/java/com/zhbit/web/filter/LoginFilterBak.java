package com.zhbit.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录验证的过滤器
 */
/*@WebFilter("/brand/*")*/
public class LoginFilterBak implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        //判断访问资源是否和登录相关
        String[] urls={"index.jsp","/login.jsp","/imgs/","/css/","/loginServlet","/register.jsp","/checkCodeServlet","/registerServlet"};
        //获取当前访问的资源路径
        String url = req.getRequestURL( ).toString( );
        System.out.println(url);

//        循环判断
        for(String u:urls){
            if(url.contains(u)){
             //放行
                chain.doFilter(request,response);
                return;
            }else if(url.contains("selectAllServlet")){
                return;
            }
        }
        HttpSession session  = req.getSession( );
        Object user = session.getAttribute("user");

        //2.判断用户是否登录
        if(user!=null){
            //登录过，放行
            chain.doFilter(request,response);
        }else{
            req.setAttribute("login_msg","你尚未登录,重新登录...");
            req.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

}
