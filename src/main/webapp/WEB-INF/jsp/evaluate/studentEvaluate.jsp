<%--
  Created by IntelliJ IDEA.
  User: YMY
  Date: 2019/5/6
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<html>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/assets/js/Chart.min.js"></script>
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
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
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
                <input type="hidden" name="code" value="${stuel.code}">
                </tbody>
            </table>
        </div>
        <script type="text/javascript">
            var code = $("input[name='code']").val().trim();
            $(function aa() {
                    $.ajax({
                        url: "${pageContext.request.contextPath }/evaluate/evaluatejson",
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
                                    result += "<td>" + el.stuname + "</td>",
                                    result += "<td>" + el.elname + "</td>",
                                    result += "<td>" + el.elnr + "</td>",
                                    result += "<td>" + el.publisher + "</td>",
                                    result += "<td><input class='form-control' type='text' name='elnr' placeholder='填写评价'/>",
                                    result += "<input class='btn btn-default' type='button' value='提交' id='addStuel'/></td>";
                                result += "</tr>";
                            });
                            $("#list").html(result);
                        },
                        error: function () {
                            alert("失败")
                        },
                        dataType: "json"
                    });
                },
                $("#addStuel").die('click').live('click', function() {
                    var elnr = $("input[name='elnr']").val();
                    $.ajax({
                        url: "${pageContext.request.contextPath}/evaluate/addStuel",
                        type: "POST",
                        data: {
                            "code": code,
                            "elnr": elnr
                        },
                        dateType: "json",
                        success: function (data) {
                            var result = "";
                            $.each(data, function (i, el) {
                                    result += "<tr>";
                                    result += "<td>" + el.id + "</td>",
                                    result += "<td>" + el.code + "</td>",
                                    result += "<td>" + el.stuname + "</td>",
                                    result += "<td>" + el.elname + "</td>",
                                    result += "<td>" + el.elnr + "</td>",
                                    result += "<td>" + el.publisher + "</td>",
                                        result += "<td><input class='form-control' type='text' name='elnr' placeholder='填写评价'/>",
                                        result += "<input class='btn btn-default' type='button' value='提交' id='addStuel'/></td>";
                                result += "</tr>";
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
    </div>
</div>
