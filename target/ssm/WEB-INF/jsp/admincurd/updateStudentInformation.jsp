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
    <title>修改论文</title>
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
                    <small>修改论文</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/updatasi" name="userForm" method="post">
        <input type="hidden" name="id" value="${studentinformation.id}"/>
        学号：<input type="text" name="codeid" value="${studentinformation.codeid}">
        名字：<input type="text" name="name" value="${studentinformation.name}"><br><br><br>
        性别：<input type="text" name="sex" value="${studentinformation.age}">
        年龄：<input type="text" name="age" value="${studentinformation.age}"><br><br><br>
        专业：<input type="text" name="speciality" value="${studentinformation.speciality}">
        号码：<input type="text" name="number" value="${studentinformation.number}"><br><br><br>
        <input class="btn btn-primary" type="submit" value="提交" />
    </form>

</div>