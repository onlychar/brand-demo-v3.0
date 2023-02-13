<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2023/1/20
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="utf-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理所有品牌列表 </title>
</head>
<body>

<h1>${user.username},欢迎您！</h1>
<input type="button" value="新增" id="add"><br>
<hr>
<div>${msg}</div>
<hr>
<jsp:include page="ajaxBrand.jsp" flush="true" />
<hr>
<a href="${contextPath}/logoutServlet">退出登录,返回登录页面</a>
 <script>
     document.getElementById("add").onclick = function (){
         alert("添加一条记录")
         location.href="${contextPath}/brand/addBrand.jsp"
     }
 </script>
</body>
</html>