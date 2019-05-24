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
    <title>新增课程</title>
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

                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增课程</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/course/addCourse" name="userForm" method="post">
        <input type="hidden" name="courseid"/>
        学号：<input type="text" name="coursecode"/><br><br><br>
        课程：<input type="text" name="coursename" /><br><br><br>
        任课老师：<input type="text" name="courseteacher" /><br><br><br>
        上课地点：<input type="text" name="courselocaltion" /><br><br><br>
        时间：<input type="text" name="coursetime" /><br><br><br>
        是否可选：<input type="text" name="coursepower" /><br><br><br>
        课程类型：<input type="text" name="coursetype" /><br><br><br>
        <input class="btn btn-primary" type="submit" value="添加" >
    </form>

<!--伟哥牛逼哈哈哈-->
</div>