<%--
  Created by IntelliJ IDEA.
  User: YMY
  Date: 2019/5/20
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<html>
<head>
    <title>重修申请</title>
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
                    <small>重修申请</small>
                </h1>
            </div>
        </div>
    </div>
    <form id="updateForm" action="/rebuild/addRebuild">
        <input type="hidden" name="id" id="id"/>
        学号：<input type="text" name="code" value="${code}" class="form-control"><br><br><br>
        姓名：<input type="text" name="name" class="form-control"><br><br><br>
        重修课程：<select name="rekemu" id="name" class="form-control"></select><br><br><br>
        <input class="btn btn-info" type="submit" id="addRebuild" value="增加">
    </form>
    <script type="text/javascript">
        $(function () {
            initKeMu();
            var code = $("input[name='code']").val().trim();
            $.ajax({
                url: "${pageContext.request.contextPath }/json",
                type: "POST",
                data: {
                    "code":code
                },
                dataType: "json",
                success: function (data) {
                    var $form = $('#updateForm');
                    $form.find("input[name='name']").val(data.name);
                },
                error: function () {
                    alert("失败")
                },
            });
        });

        function initKeMu() {
            $.ajax({
                url: "${pageContext.request.contextPath }/course/json.action",
                type: "POST",
                data: {
                },
                dataType: "json",
                success: function (data) {
                    var options = "<option></option>";
                    for (var i = 0; i < data.length; i++) {
                        options += "<option value= '"+data[i].coursename+"'>" + data[i].coursename + "</option>"
                    }
                    $("#name").html("").append(options);
                },
                error: function () {
                    alert("失败")
                },
            });
        }


    </script>
</div>
