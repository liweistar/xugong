<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/4/6
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
    $(function aa() {
        $.ajax({
            url: "${pageContext.request.contextPath }/json.action",
            type: "POST",
            dataType: 'json',
            data: {},
            success: function (data) {
                var result = "";

                $.each(data, function (i, el) {
                    result += "<tr>";
                    result += "<td>" + el.codeid + "</td>";
                    result += "<td>" + el.name + "</td>";
                    result += "<td>" + el.sex + "</td>";
                    result += "<td>" + el.age + "</td>";
                    result += "<td>" + el.speciality + "</td>";
                    result += "<td>" + el.number + "</td>";
                    // result += "<td>" + "<img src='/pic/el.'/> "+"<input type='file' name='filename'/>"+ "</td>"

                    result += "<td><a  href='${pageContext.request.contextPath}/toupdatasi?id=" + el.id + "'>修改</a> "
                    result += "<a href='${pageContext.request.contextPath}/deletesi?codeid=" + el.codeid + "'>删除</a> </td>"
                    result += "</tr>";
                });
                $("#list").html(result);
            },
            error: function () {
                alert("失败")
            },

        })
    });

    function exportAchievementExcel() {
        $.post("/excel", $(".achievement-table-form").serialize(), function (r) {
            if (r.code === 0) {
                window.location.href = "/common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                alert("失败")
            }
        });
    }
</script>
<head>
    <title>管理员修改学生信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="container">

        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>学生信息</small>
                    </h1>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 column">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/toadddatasi">新增</a>
                <a class="btn btn-primary" href="javascript:void(0)" class="dropdown-item" data-table-action="excel" onclick="exportAchievementExcel()">
                    生成报表
                </a>
            </div>
        </div>

            <div id="data-table_filter" class="dataTables_filter">
                <form class="achievement-table-form">
                </form>
            </div>

            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-hover table-striped">
                        <thead>
                <tr>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>专业</th>
                    <th>号码</th>
                    <th>操作</th>
                </tr>
                        </thead>
                <tbody id="list"></tbody>

            </table>
                </div>
            </div>

            <div>${fail}</div>
</div>
</div>
</body>
