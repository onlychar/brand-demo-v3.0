package com.zhbit.web;

import com.alibaba.fastjson.JSON;
import com.zhbit.pojo.Brand;
import com.zhbit.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/brand/ajaxAddServlet")
public class AjaxAddServlet extends HttpServlet {
    private BrandService brandService = new BrandService( );
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.接收数据，request.getParameter()不接收json数据
        //设置请求体数据
        BufferedReader br = request.getReader( );
        String param = br.readLine( );

        //将JSON字符串转换为Java对象
        Brand brand = JSON.parseObject(param, Brand.class);

//        2.调用service添加
       int i=  brandService.add(brand);
//        3.响应成功标示
        if(i>0) {
            request.setAttribute("msg","系统通知：成功添加"+i+"条品牌记录");//目前没有用
            response.getWriter().write("success");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
