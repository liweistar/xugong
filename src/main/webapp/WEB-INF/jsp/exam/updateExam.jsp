<%--
  Created by IntelliJ IDEA.
  User: YMY
  Date: 2019/5/19
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
    $(function () {
        var id = $("input[name='id']").val().trim();
        $.ajax({
            url: "${pageContext.request.contextPath }/exam/getAllById",
            type: "POST",
            data: {
                "id":id
            },
            success: function (data) {
                var $form = $('#updateForm');
                $form.find("input[name='id']").val(data.id);
                $form.find("input[name='code']").val(data.code);
                $form.find("input[name='name']").val(data.name);
                $form.find("input[name='kemu']").val(data.kemu);
                $form.find("input[name='time']").val(data.time);
                $form.find("input[name='status']").val(data.status);
            },
            error: function () {
                alert("失败")
            },
            dataType: "json"
        });
    });
    var code = $("input[name='code']").val().trim();
    var name = $("input[name='name']").val().trim();
    var kemu = $("input[name='kemu']").val().trim();
    var time = $("input[name='time']").val().trim();
    var status = $("input[name='status']").val().trim();
    $("#edit").click(function () {
        $.ajax({
            url: "${pageContext.request.contextPath }/exam/updateExam",
            type: "POST",
            data: {
                "code": code,
                "name": name,
                "keone": keone,
                "ketwo": ketwo,
                "kethree": kethree,
                "kefour": kefour,
                "kefive": kefive
            },
            dataType: "json",
            success: function (r) {
                if (r.code === 0) {

                } else {
                    alert("失败")
                }
            }
        });
    })
</script>
<html>
<head>
    <title>修改考试安排查询</title>
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
                    <small>修改考试安排查询</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/exam/updateExam" id="updateForm" method="post">
        <input type="hidden" name="id" id="id" value="${exam.id}"/>
        学号：<input type="text" name="code" class="form-control"><br><br><br>
        姓名：<input type="text" name="name" class="form-control"><br><br><br>
        考试科目：<input type="text" name="kemu" class="form-control"><br><br><br>
        考试时间：<input type="text" name="time" class="form-control"><br><br><br>
        状态：<input type="text" name="status" class="form-control"><br><br><br>
        <button class="btn btn-info" id="edit">修改</button>
    </form>

</div>
