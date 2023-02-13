package com.zhbit.web;

import com.zhbit.pojo.User;
import com.zhbit.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService( );
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        获取复选框数据
        String remember = request.getParameter("remember");

//        2.调用service查询User
        User user = service.login(username, password);

//        3.判断User是否为null
        if(user!=null) {
//            判断用户是否勾选记住我
            if("1".equals(remember)){
                //创建cookie，设置存活时间，发送cookie
                Cookie c_uname=new Cookie("uname",username);
                Cookie c_upass=new Cookie("upass",password);
                c_uname.setMaxAge(7*24*3600);
                c_upass.setMaxAge(7*24*3600);
                response.addCookie(c_uname);
                response.addCookie(c_upass);
            }
            String contextPath = request.getContextPath( );
            //登录成功，1.将登陆成功后的user对象，存储的session中，然后 2. 跳转到查询所有的brandServlet
            HttpSession session = request.getSession( );
            session.setAttribute("user",user);
            response.sendRedirect(contextPath+"/brand/brand.jsp");
        }else{
//            存储错误信息到request
            request.setAttribute("login_msg","用户名或密码错误");
            //登录失败,跳转回login.jsp
            request.getRequestDispatcher("login.jsp").forward(request,response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
