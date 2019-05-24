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
    <title>修改课程信息</title>
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
                   管理员
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改课程信息</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/course/updateCourse" name="userForm" method="post">
        <input type="hidden" name="courseid" value="${course.courseid}"/>
        学号：<input type="text" name="coursecode" value="${course.coursecode}"/>
        课程：<input type="text" name="coursename" value="${course.coursename}"/>
        任课老师：<input type="text" name="courseteacher" value="${course.courseteacher }"/>
        上课地点：<input type="text" name="courselocaltion" value="${course.courselocaltion }"/>
        时间：<input type="text" name="coursetime" value="${course.coursetime}"/>
        是否可选：<input type="text" name="coursepower" value="${course.coursepower }"/>
        课程类型：<input type="text" name="coursetype" value="${course.coursetype }"/>
        <input type="submit" value="提交" />
    </form>

</div>