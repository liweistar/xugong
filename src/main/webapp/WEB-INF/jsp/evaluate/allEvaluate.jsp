<%--
  Created by IntelliJ IDEA.
  User: YMY
  Date: 2019/5/6
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<html>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/assets/js/Chart.min.js"></script>
<script type="text/javascript">
    $(function () {

        $.ajax({
            url: "${pageContext.request.contextPath }/evaluate/json.action",
            type: "POST",
            data: {},
            success: function (data) {
                var result = "";
                $(data).each(function (i, el) {
                        result += "<tr>";
                        result += "<td>" + el.id + "</td>",
                            result += "<td>" + el.code + "</td>",
                        result += "<td>" + el.stuname + "</td>",
                        result += "<td>" + el.elname + "</td>",
                        result += "<td>" + el.elnr + "</td>",
                        result += "<td>" + el.publisher + "</td>",
                        result += "<td><a href='${path}/evaluate/toUpdateEvaluate?id=" + el.id + "'>更改</a>",
                        result += "<a href='${path}/evaluate/del?id=" + el.id + "'>删除</a></td>",
                        result += "</tr>";
                });
                $("#list").html(result);
            },
            error: function () {
                alert("失败")
            },
            dataType: "json"
        });
    });
</script>
<head>
    <title>评价列表</title>
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
                    学生评价
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>学生评价</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${path}/evaluate/toAddEvaluate">新增</a>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-responsive table-hover dataTable no-footer">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>学号</th>
                    <th>学生姓名</th>
                    <th>评价名称</th>
                    <th>评价内容</th>
                    <th>发布人</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="list">
                </tbody>
            </table>
        </div>
    </div>
</div>
