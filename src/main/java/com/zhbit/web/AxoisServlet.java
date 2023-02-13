package com.zhbit.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ajax/axoisServlet")
public class AxoisServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get。。。" );
        //1.
        String username = request.getParameter("username");
        System.out.println(username);

        //2.相应更新
        response.getWriter().write("hello Axois...");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post。。。" );
        this.doGet(request, response);
    }
}
