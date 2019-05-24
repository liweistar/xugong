<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/4/7
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<html>
<head>
    <title>新增学生评价</title>
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
                    基于SSM框架的管理系统：简单实现增、删、改、查。
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增评价</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/evaluate/addEvaluate" method="post">
        <input type="hidden" name="id" id="id"/>
<%--        学号：<input type="text" name="code"><br><br><br>--%>
<%--        学生姓名：<input type="text" name="stuname"><br><br><br>--%>
        评价名称：<input class="form-control" type="text" name="elname"><br><br><br>
        发布人：<input class="form-control" type="text" name="publisher"><br><br><br>
        <input class="btn btn-info" type="submit" value="增加">
    </form>

</div>