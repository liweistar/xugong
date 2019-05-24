<%--
  Created by IntelliJ IDEA.
  User: YMY
  Date: 2019/5/20
  Time: 9:40
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
                url: "${pageContext.request.contextPath }/rexam/rexamjson",
                type: "POST",
                data: {},
                success: function (data) {
                    var result = "";
                    $(data).each(function (i, el) {
                        result += "<tr>";
                        result += "<td>" + el.id + "</td>",
                            result += "<td>" + el.code + "</td>",
                            result += "<td>" + el.name + "</td>",
                            result += "<td>" + el.rkemu + "</td>",
                            result += "<td>" + el.status + "</td>",
                            result += "<td><input class='btn btn-info' type='button' id='update' value='审核'/></td>",
                            result += "<input type='hidden' name='code' value='"+el.code+"'/></tr>";
                    });
                    $("#list").html(result);
                },
                error: function () {
                    alert("失败")
                },
                dataType: "json"
            });
        },
        $("#update").die('click').live('click', function() {
            var code = $("input[name='code']").val();
            $.ajax({
                url: "${pageContext.request.contextPath}/rexam/updateStatus",
                type: "POST",
                data: {
                    "code": code
                },
                dateType: "json",
                success: function (data) {
                    var result = "";
                    $.each(data, function (i, el) {
                        result += "<tr>";
                        result += "<td>" + el.id + "</td>",
                            result += "<td>" + el.code + "</td>",
                            result += "<td>" + el.name + "</td>",
                            result += "<td>" + el.rkemu + "</td>",
                            result += "<td>" + el.status + "</td>",
                            result += "<td><input class='btn btn-info' type='button' id='update' value='审核'/></td>",
                            result += "<input type='hidden' name='"+el.code+"'/></tr>";
                    });
                    $("#list").html(result);
                },
                error: function () {
                    alert("失败")
                }
            })
        })
    )
</script>
<head>
    <title>重考申请</title>
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
                    重考申请
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>重考申请</small>
                </h1>
            </div>
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
                    <th>重考科目</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="list">
                </tbody>
            </table>
        </div>
    </div>
</div>
