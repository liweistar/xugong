<%--
  Created by IntelliJ IDEA.
  User: YMY
  Date: 2019/5/15
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<html>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/assets/js/Chart.min.js"></script>
<head>
    <title>免修</title>
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
                    免修
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>免修</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${path}/mian/toAddMian?code=${mian.code}">新增</a>
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
                    <th>科目</th>
                    <th>凭证</th>
                    <th>状态</th>
                </tr>
                </thead>
                <tbody id="list">
                <input type="hidden" name="code" value="${mian.code}">

                </tbody>

            </table>
            <div>${wu}</div>
        </div>
        <script type="text/javascript">
            var code = $("input[name='code']").val().trim();
            $(function aa() {
                    $.ajax({
                        url: "${pageContext.request.contextPath }/mian/json",
                        type: "POST",
                        data: {
                            "code": code
                        },
                        success: function (data) {
                            var result = "";
                            $(data).each(function (i, el) {
                                result += "<tr>";
                                result += "<td>" + el.id + "</td>",
                                    result += "<td>" + el.code + "</td>",
                                    result += "<td>" + el.name + "</td>",
                                    result += "<td>" + el.kemu + "</td>",
                                    result += "<td>" + el.ping + "</td>",
                                    result += "<td>" + el.status + "</td>",
                                result += "</tr>";
                            });
                            $("#list").html(result);
                        },
                        error: function () {

                        },
                        dataType: "json"
                    });
                })
        </script>
    </div>
</div>

