package com.zhbit.web;

import com.zhbit.pojo.User;
import com.zhbit.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService service = new UserService( );
    private String msg;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //获得输入的 验证吗
        String checkCode = request.getParameter("checkCode");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //程序生成的验证码，从session获取
        HttpSession session = request.getSession( );
        String checkCodeGen = (String) session.getAttribute("checkCode");
        if(!checkCodeGen.equalsIgnoreCase(checkCode)){
            //注册失败
            request.setAttribute("register_msg","验证码失败");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            //不允许注册
            return;
        }
        //2. 调用service
        boolean flag = service.register(user);
        msg = "register_msg";
//        3.判断注册成功与否
        if(flag)
        {
            request.setAttribute(msg,"注册成功，请登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }   else{

            //注册失败
            request.setAttribute(msg,"注册失败，请重新注册");
            request.getRequestDispatcher("/register.jsp").forward(request,response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
