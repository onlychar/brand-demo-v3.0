<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2023/1/21
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<!DOCTYPE html>
<html lang="cn">

<head>
    <meta charset="UTF-8">
    <title>添加一个品牌</title>
</head>
<body>
<div id="app">
    <h3>添加品牌</h3>
    <%--ajax的提交请求form标签不需要action和method属性设置--%>
    <form>
        品牌名称：<input id="brandName" v-model="brand.brandName" name="brandName"><br>
        企业名称：<input id="companyName" v-model="brand.companyName" name="companyName"><br>
        排序：<input id="ordered" v-model="brand.ordered" name="ordered"><br>
        描述信息：<textarea id="description" v-model="brand.description" rows="5" cols="20" name="description"></textarea><br>
        状态：
        <input type="radio" name="status" v-model="brand.status" value="0">禁用
        <input type="radio" name="status" v-model="brand.status" value="1">启用<br>

        <input type="button" id="btn_submit" @click="submitForm" value="提交">
    </form>
</div>
<script src="${contextPath}/js/axios-0.18.0.js"></script>
<script src="${contextPath}/js/vue.js"></script>
<script>
    new Vue({
        el: "#app",
        data(){
          return{
              brand:{}
          }
        },
        methods:{ //注意是methods而不是method
            submitForm(){
                let _this=this;
                // 发送ajax请求
                axios({
                    method:"post",
                    url:"http://localhost:8080${contextPath}/brand/ajaxAddServlet",
                    data:_this.brand
                }).then(function (resp){
                    // 判断响应数据是否为successs
                    if(resp.data == "success"){
                        location.href = "http://localhost:8080${contextPath}/brand/brand.jsp"
                    }
                })
            }
        }
    })
    /*// 1.给按钮绑定单击事件
    document.getElementById("btn_submit").onclick = function (){
      //将表单数据转为json
      let formData = {
        brandName:"",
        companyName:"",
        ordered:"",
        description:"",
        status:"",
      };
      //获取表单数据并设置表单数据
      let brandName = document.getElementById("brandName").value;
      // 设置数据
      formData.brandName = brandName;
      //获取表单数据并设置表单数据
      let companyName = document.getElementById("companyName").value;
      // 设置数据
      formData.companyName = companyName;
      //获取表单数据并设置表单数据
      let ordered = document.getElementById("ordered").value;
      // 设置数据
      formData.ordered = ordered;
      //获取表单数据并设置表单数据
      let description = document.getElementById("description").value;
      // 设置数据
      formData.description = description;
      let status = document.getElementsByName("status");
      for (let i = 0; i < status.length; i++) {
        if(status[i].checked){
          formData.status = status[i].value;
        }
      }
      console.log(formData);
      // 2.发送ajax请求
      axios({
          method:"post",
          url:"http://localhost:8080${contextPath}/brand/ajaxAddServlet",
        data:formData
    }).then(function (resp){
        // 判断响应数据是否为successs
      if(resp.data == "success"){
        location.href = "http://localhost:8080${contextPath}/brand/brand.jsp"
      }
    })
  }*/
</script>
</body>
</html>