<%--
Created by IntelliJ IDEA.
User: DELL
Date: 2023/1/21
Time: 11:11
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<% String contextPath= request.getContextPath(); pageContext.setAttribute("contextPath",contextPath); %>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link href="${contextPath}/css/register.css" rel="stylesheet">
</head>
<body>

<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="login.jsp">登录</a>
    </div>
    <form id="reg-form" action="${contextPath}/registerServlet" method="post">

        <table>

            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input name="username" value = "zhangsan" type="text" id="username">
                    <br>
                    <span id="username_err" class="err_msg">${register_msg}</span>
                   <%-- <span id="username_exist" class="err_msg" style="display: none">用户名已经存在数据库</span>--%>
                </td>

            </tr>

            <tr>
                <td>密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">
                    <br>
                    <span id="password_err" class="err_msg"></span>
                </td>
            </tr>


            <tr>
                <td>验证码</td>
                <td class="inputs">
                    <input name="checkCode" type="text" id="checkCode">
                    <img id ="checkCodeImg" src="${contextPath}/checkCodeServlet">

                    <a href="#" id="changeImg">看不清？</a>
                </td>
            </tr>

        </table>

        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>

        <br class="clear">
    </form>

</div>
</body>
<script>
    var xhttp;
    if(window.XMLHttpRequest){
        xhttp = new XMLHttpRequest();
    }else{
        xhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    //1. 验证用户名是否符合规则
    //1.1 获取用户名的输入框
    var usernameInput = document.getElementById("username");

    //1.2 绑定onblur事件 失去焦点
    usernameInput.onblur = checkUsername;

    function checkUsername() {
        //1.3 获取用户输入的用户名
        var username = usernameInput.value.trim();

        //1.4 判断用户名是否符合规则：长度 6~12,单词字符组成
        var reg = /^\w{6,12}$/;
        var flag = reg.test(username);

        //var flag = username.length >= 6 && username.length <= 12;
        if (!flag) {
            //符合规则
            document.getElementById("username_err").innerText = '长度在6-12个字符之间';
        }else{
            document.getElementById("username_err").innerText = '';
        }
        return flag;
    }


    //1. 验证密码是否符合规则
    //1.1 获取密码的输入框
    var passwordInput = document.getElementById("password");

    //1.2 绑定onblur事件 失去焦点
    passwordInput.onblur = checkPassword;

    function checkPassword() {
        //1.3 获取用户输入的密码
        var password = passwordInput.value.trim();

        //1.4 判断密码是否符合规则：长度 6~12
        var reg = /^\w{6,12}$/;
        var flag = reg.test(password);

        //var flag = password.length >= 6 && password.length <= 12;
        if  (!flag) {
            //符合规则
            document.getElementById("password_err").innerText = '长度在6-12个字符之间';
        }else{
            document.getElementById("password_err").innerText = '';
        }
        return flag;
    }



    //1. 获取表单对象
    var regForm = document.getElementById("reg-form");

    //2. 绑定onsubmit 事件
    regForm.onsubmit = function () {
        //挨个判断每一个表单项是否都符合要求，如果有一个不合符，则返回false

        var flag = checkUsername() && checkPassword();

        return flag;
    }

</script>
<script>
    document.getElementById("changeImg").onclick = function (){
        document.getElementById("checkCodeImg").src = "${contextPath}/checkCodeServlet?"+new Date().getMilliseconds();
    }
    // 1.给用户名输入框绑定 失去焦点事件
    document.getElementById("username").onblur =function (){
        //2.发送ajax请求
        // 获取用户名的值
        var username=this.value;
        //2.1.创建核心对象
        var xhttp;
        if (window.XMLHttpRequest) {
            xhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        //2.2.发送请求
        xhttp.open("GET","http://localhost:8080/brand-demo/ajax/selectUserServlet?username="+username);
        xhttp.send();
        //2.3.获取响应
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                //判断
                if(this.responseText =="true"){
                    //用户名存在，显示提示信息
                    document.getElementById("username_err").innerText = "用户名已经存在";
                    // document.getElementById("username_exist").style.display="";
                }else{
                    //用户名不存在，清楚提示信息
                    document.getElementById("username_err").innerText = "";
                    // document.getElementById("username_exist").style.display="none";
                }

            }
        };
    }
</script>
</html>