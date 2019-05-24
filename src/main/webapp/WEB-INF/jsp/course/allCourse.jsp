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
<script type="text/javascript">

    $("#selbtn1").die('click').live('click', function () {
        $.ajax({
            url: '${pageContext.request.contextPath }/course/select.action',
            data: {"coursetype": $("#condition").val()},
            dataType: 'json',
            error: function () {
                alert("请求出错.")
            },
            success: function (data) {
                var result = "";
                $.each(data, function (i, el) {
                    result += "<tr>";
                    result += "<td>" + el.coursecode + "</td>"
                    result += "<td>" + el.coursename + "</td>"
                    result += "<td>" + el.courseteacher + "</td>"
                    result += "<td>" + el.courselocaltion + "</td>"
                    result += "<td>" + el.coursetime + "</td>"
                    result += "<td>" + el.coursepower + "</td>"
                    result += "<td>" + el.coursetype + "</td>"
                    result += "<td><a href='${path}/course/toUpdatePcourse?id=" + el.courseid + "'>更改</a> "
                    result += "<a href='${path}/course/delete?id=" + el.courseid + "'>删除</a> </td>"
                    result += "</tr>";
                });
                $("#list").html(result);
            },
            type: 'POST'
        })
    });
    //更改权限
    $("#cz").die('click').live('click', function() {
        var code = $("input[name='code']").val().trim();
        var qian = $("input[name='qian']").val().trim();
        $.ajax({

            url: "${pageContext.request.contextPath}/card/chongzhi",
            type: "POST",
            data: {

                "code": code,
                "qian": qian
            },
            dateType:"json",
            success: function (data) {

                var result = "";

                $.each(data, function (i, el) {
                    result += "<tr>";
                    result += "<td>" +code + "</td>";
                    result += "<td>" + el.name+ "</td>";
                    result += "<td>" + el.speciality + "</td>";
                    result += "<td>" + el.money + "</td>";
                    result += "<td>" + el.power + "</td>";
                    result += "<td>" + el.date + "</td>";
                    result +=  "<td><input type='text' name='qian' placeholder='请充值' id='qian'>";
                    result +=  " <input type='button' class='btn btn-primary' value='充值' id='cz'/></td>";

                });
                $("#list").html(result);
            },
            error: function () {
                alert("失败")
            }
        })
    })
    $(function aa() {
        $.ajax({
            url: "${pageContext.request.contextPath }/course/json.action",
            type: "POST",
            dataType: 'json',
            data: {},
            success: function (data) {
                var result = "";

                $.each(data, function (i, el) {
                    result += "<tr>";
                    result += "<td>" + el.coursecode + "</td>"
                    result += "<td>" + el.coursename + "</td>"
                    result += "<td>" + el.courseteacher + "</td>"
                    result += "<td>" + el.courselocaltion + "</td>"
                    result += "<td>" + el.coursetime + "</td>"
                    result += "<td>" + el.coursepower + "</td>"
                    result += "<td>" + el.coursetype + "</td>"


                    result += "<td><a href='${pageContext.request.contextPath}/course/toUpdateCourse?id=" + el.courseid + "'>更改</a> "
                    result += "<a href='${pageContext.request.contextPath}/course/delete?id=" + el.courseid + "'>删除</a>&nbsp; "
                    result += "<a href='${pageContext.request.contextPath}/course/updatapower?id=" + el.courseid + "'>更改权限</a></td>"
                    result += "</tr>";
                });
                $("#list").html(result);
            },
            error: function () {
                alert("失败")
            },

        })
    });


</script>
<head>
    <title>课程管理</title>
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

        <div class="col-md-4 column">
            <input type="text" id="condition"/>
            <a class="btn btn-primary"  id="selbtn1">条件查询</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/course/toAddCourse">新增</a>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>学号</th>
                    <th>课程</th>
                    <th>任课老师</th>
                    <th>上课地点</th>
                    <th>时间</th>
                    <th>是否可选</th>
                    <th>课程类型</th>
                    <th>操作</th>
                </tr>
                </thead>
               <tbody id="list"></tbody>
            </table>

        </div>
    </div>
</div>
</body></html>