package com.zhbit.web;

import com.zhbit.pojo.User;
import com.zhbit.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ajax/selectUserServlet")
public class SelectUserServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.接收用户名
        String username = request.getParameter("username");
//        2.调用service查询User

        boolean flag = true;
        User user = userService.selectUserByUsername(username.trim());
        flag = (user == null) ? false : true;
//        3.返回标记 1.标示存在
        response.getWriter().write(""+flag);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
