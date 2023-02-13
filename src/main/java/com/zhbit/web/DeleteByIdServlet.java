package com.zhbit.web;

import com.zhbit.pojo.Brand;
import com.zhbit.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.zhbit.util.CodeUtil.toUtf8;

@WebServlet("/brand/deleteByIdServlet")
public class DeleteByIdServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理乱码
//        request.setCharacterEncoding("utf-8");
        //接收表达数据，获取数据
        String id = request.getParameter("id");
        //2.调用service 完成添加
        int i = service.deleteById(Integer.parseInt(id));
        request.setAttribute("msg","系统通知：成功删除"+i+"条品牌记录");
        //转发的查询所有的servlet
        request.getRequestDispatcher("/brand/brand.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
