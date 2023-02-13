package com.zhbit.web;

import com.zhbit.pojo.Brand;
import com.zhbit.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/brand/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    private BrandService brandService= new BrandService();;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收id
        String id = request.getParameter("id");
//        2.调用service查询 Brand
        Brand brand = brandService.selectById(Integer.parseInt(id));
//        3.存储request
        request.setAttribute("brand",brand);

//        4.转发修改页面
        request.getRequestDispatcher("/brand/update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
