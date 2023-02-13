package com.zhbit.web.bak;

import com.zhbit.pojo.Brand;
import com.zhbit.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static com.zhbit.util.CodeUtil.toUtf8;

/*@WebServlet("/brand/addServlet")*/
public class AddServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理乱码
//        request.setCharacterEncoding("utf-8");
        //接收表达数据，获取数据
        String brandName =toUtf8(request.getParameter("brandName")) ;
        String companyName = toUtf8(request.getParameter("companyName"));
        String ordered = request.getParameter("ordered");
        String description =toUtf8(request.getParameter("description"));
        String status = request.getParameter("status");
        //封装成brand对象
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName        );
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));
        //2.调用service 完成添加
        int i= service.add(brand);
        request.setAttribute("msg","系统通知：成功添加"+i+"条品牌记录");
        //转发的查询所有的servlet
        request.getRequestDispatcher("/brand/selectAllServlet").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
