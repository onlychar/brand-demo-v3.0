package com.zhbit.web.bak;

import com.zhbit.pojo.Brand;
import com.zhbit.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/*@WebServlet("/brand/selectAllServlet")*/
public class SelectAllServlet extends HttpServlet {

    private BrandService brandService= new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.调用brandService完成查询
//        List<Brand> brands = brandService.selectAll();

//        2.存入request范围
//        request.setAttribute("brands", brands);
//        3.转发到Brand.jsp
        request.getRequestDispatcher("/brand/brand.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
