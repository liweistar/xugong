<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/5/21
  Time: 21:51
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
        $.post("course/recommend",function(data) {
            var result = "";
            for (var i = 0; i < data.length; i++) {
                result += "<tr>";
                result += "<td>" + data[i].coursecode + "</td>";
                result += "<td>" + data[i].coursename + "</td>";
                result += "<td>" + data[i].courseteacher+ "</td>";
                result += "<td>" + data[i].courselocaltion + "</td>";
                result += "<td>" + data[i].coursetime + "</td>";
                result += "<td>" + data[i].coursetype + "</td>";
                result += "<td>" + data[i].selcount + "</td>";
                result += "<td>"+"<a href='select?id="+data[i].courseid+"'><span class=\"glyphicon glyphicon-ok\">选课</span></a>"+ "</td>";
                result += "</tr>";
            }
            $("#mytbody").html(result);
        })
    })
</script>
<head>
    <title>Title</title>
</head>
<body>
<table class="table table-hover">
    <thead>
    <tr>
        <td>课程代码</td>
        <td>课程名</td>
        <td>授课教师</td>
        <td>上课地点</td>
        <td>上课时间</td>
        <td>课程类型</td>
        <td>选课人数</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody id="mytbody"></tbody>
</table>
</body>
</html>
