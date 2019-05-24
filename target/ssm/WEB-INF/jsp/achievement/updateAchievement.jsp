<%--
  Created by IntelliJ IDEA.
  User: YMY
  Date: 2019/5/14
  Time: 11:56
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
            url: "${pageContext.request.contextPath }/achievement/getAllById",
            type: "POST",
            data: {
                "id":id
            },
            success: function (data) {
                var $form = $('#updateForm');
                $form.find("input[name='id']").val(data.id);
                $form.find("input[name='code']").val(data.code);
                $form.find("input[name='name']").val(data.name);
                $form.find("input[name='keone']").val(data.keone);
                $form.find("input[name='ketwo']").val(data.ketwo);
                $form.find("input[name='kethree']").val(data.kethree);
                $form.find("input[name='kefour']").val(data.kefour);
                $form.find("input[name='kefive']").val(data.kefive);
            },
            error: function () {
                alert("失败")
            },
            dataType: "json"
        });
    });
    var code = $("input[name='code']").val().trim();
    var name = $("input[name='name']").val().trim();
    var keone = $("input[name='keone']").val().trim();
    var ketwo = $("input[name='ketwo']").val().trim();
    var kethree = $("input[name='kethree']").val().trim();
    var kefour = $("input[name='kefour']").val().trim();
    var kefive = $("input[name='kefive']").val().trim();
    $("#edit").click(function () {
        $.ajax({
            url: "${pageContext.request.contextPath }/achievement/updateAchievement",
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
    <title>修改成绩</title>
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
                    <small>修改成绩</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/achievement/updateAchievement" id="updateForm" method="post">
        <input type="hidden" name="id" id="id" value="${achievement.id}"/>
        学号：<input class="form-control" type="text" name="code" class="form-control"><br><br><br>
        姓名：<input class="form-control" type="text" name="name" class="form-control"><br><br><br>
        计算机导论：<input class="form-control" type="text" name="keone" class="form-control"><br><br><br>
        c++：<input class="form-control" type="text" name="ketwo" class="form-control"><br><br><br>
        java框架：<input class="form-control" type="text" name="kethree" class="form-control"><br><br><br>
        英语：<input class="form-control" type="text" name="kefour" class="form-control"><br><br><br>
        高数：<input class="form-control" type="text" name="kefive" class="form-control"><br><br><br>
        <button class="btn btn-info" id="edit">修改</button>
    </form>

</div>
