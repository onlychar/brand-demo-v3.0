<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <title>Ajax获取品牌列表</title>
</head>
<body>
<div id="app">
<table id="brandTable" border="1" cellspacing="0" width="100%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <tr v-for="(brand,i) in brands" align="center">
        <td>{{i}}</td>
        <td>{{brand.brandName}}</td>
        <td>{{brand.companyName}}</td>
        <td>{{brand.ordered}}</td>
        <td>{{brand.description}}</td>
        <td>{{brand.statusStr}}</td>
        <td><a :href="'${contextPath}/brand/selectByIdServlet?id='+brand.id">修改</a>
            <a :href="'${contextPath}/brand/deleteByIdServlet?id='+brand.id">删除</a>
        </td>
<%--    在标签的属性中无法通过{{}}来获得相关的插值表达式的值，需要不加{{}}标签，见上述正确代码
        <td><a href="${contextPath}/brand/selectByIdServlet?id="+{{brand.id}}>修改</a>
             <a href="${contextPath}/brand/deleteByIdServlet?id="+{{brand.id}}>删除</a></td>--%>
    </tr>

</table>
</div>
<script src="${contextPath}/js/axios-0.18.0.js"></script>
<script src="${contextPath}/js/vue.js"></script>
<script>
    new Vue({
        el:"#app",
        data(){
            return{
                // 集合对象作为模型数据返回
                brands:[]

            }
        },
        mounted() {
            // 页面加载完成后，发送异步数据,查询数据
            var _this = this;
            axios({
                method:"get",
                url:"http://localhost:8080/brand-demo/brand/ajaxSelectAllServlet"
            }).then(function (resp) {
                _this.brands = resp.data;
            })
        },

    })

</script>
</body>
</html>
