<%--
Created by IntelliJ IDEA.
User: DELL
Date: 2023/1/20
Time: 17:57
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<%--<% String contextPath= request.getContextPath(); pageContext.setAttribute("contextPath",contextPath); %>--%>
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="${contextPath}/css/login.css" rel="stylesheet">
</head>

<body>

<div id="loginDiv" style="height: 350px">
    <form action="${contextPath}/loginServlet" id="form" method="post">
        <h1 id="loginMsg">登  录</h1>
        <div id="errorMsg">${login_msg} ${register_msg}</div>
        <p>用户名:<input id="username" name="username" type="text" value="${cookie.uname.value}"></p>

        <p>密码:<input id="password" name="password" type="password" value="${cookie.upass.value}"></p>
        <p>记忆密码:<input id="remember" name="remember" value="1" type="checkbox"></p>
        <div id="subDiv">
            <input type="submit" class="button" value="现在登录">
            <input type="reset" class="button" value="重置">&nbsp;&nbsp;&nbsp;
            <a href="register.jsp">没有账号？注册一下</a>
        </div>
    </form>
</div>

</body>
</html>