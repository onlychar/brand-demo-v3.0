package com.zhbit.web;

import com.alibaba.fastjson.JSON;
import com.zhbit.pojo.Brand;
import com.zhbit.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/ajaxSelectAllServlet")
public class AjaxSelectAllServlet extends HttpServlet {

    private BrandService brandService= new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.调用brandService完成查询
        List<Brand> brands = brandService.selectAll();
//        2.转换为JSON数据
        String jsonString = JSON.toJSONString(brands);
//         3.把字符串响应数据
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().write(jsonString);
//        System.out.println("-----" +jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
