<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/5/21
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<%--<link rel="stylesheet" href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">--%>
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<%--<script src="resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>--%>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
    $(function(){
        $.post("course/ctable", function (data) {
            var result = "";
            for (var i = 0; i < data.length; i++) {
                result += "<tr>";
                result += "<td>" + data[i].coursecode + "</td>";
                result += "<td>" + data[i].coursename + "</td>";
                result += "<td>" + data[i].courseteacher + "</td>";
                result += "<td>" + data[i].courselocaltion + "</td>";
                result += "<td>" + data[i].coursetime + "</td>";
                result += "<td>" + data[i].coursetype + "</td>";
                result += "</tr>";
            }
            $("#mytbody").html(result);
        });
        $.post("selected",function(data) {
            var result = "";
            for (var i = 0; i < data.length; i++) {
                result += "<tr>";
                result += "<td>" + data[i].course.coursecode + "</td>";
                result += "<td>" + data[i].course.coursename + "</td>";
                result += "<td>" + data[i].course.courseteacher+ "</td>";
                result += "<td>" + data[i].course.courselocaltion + "</td>";
                result += "<td>" + data[i].course.coursetime + "</td>";
                result += "<td>" + data[i].course.coursetype + "</td>";
                result += "</tr>";
            }
            $("#mytbody1").html(result);
        })
    })
</script>
<head>
    <title>个人所有课程</title>
</head>
<body>
<table class="table table-hover">
    <thead>
    <tr>
        <th>课程代码</th>
        <th>课程名</th>
        <th>授课教师</th>
        <th>上课地点</th>
        <th>上课时间</th>
        <th>课程类型</th>
    </tr>
    </thead>
    <tbody id="mytbody"></tbody>
    <tbody id="mytbody1"></tbody>
</table>
</body>
</html>
