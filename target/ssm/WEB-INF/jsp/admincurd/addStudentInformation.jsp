<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/4/7
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>修改学生信息</title>
</head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 引入 Bootstrap -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>增加学生信息</small>
                </h1>
            </div>
        </div>
    </div>
<form action="${pageContext.request.contextPath}/adddatasi" name="userForm" method="post">
    学号：<input type="text" name="codeid">
    名字：<input type="text" name="name"><br><br><br>
    性别：<input type="text" name="sex">
    年龄：<input type="text" name="age"><br><br><br>
    专业：<input type="text" name="speciality">
    号码：<input type="text" name="number"><br><br><br>
    <input class="btn btn-primary" type="submit" value="添加">
</form>

</div>
</body>
</html>