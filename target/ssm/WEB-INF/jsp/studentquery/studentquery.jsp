<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/4/6
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<html>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script>
    $("#click1").click(function () {
        window.location.href = "${pageContext.request.contextPath}/lostcard/back";
    })
</script>
<head>
    <title>一卡通信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>课程管理</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">


        <table class="table table-hover table-striped">
            <thead>
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>专业</th>
                <th>号码</th>

            </tr>
            </thead>
            <tr>
                <td>${studentinformation.codeid}</td>
                <td>${studentinformation.name}</td>
                <td>${studentinformation.sex}</td>
                <td>${studentinformation.age}</td>
                <td>${studentinformation.speciality}</td>
                <td>${studentinformation.number}</td>
            </tr>
        </table>

    </div>
</div>

</body>
</html>
