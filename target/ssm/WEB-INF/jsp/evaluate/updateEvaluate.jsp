<%--
  Created by IntelliJ IDEA.
  User: YMY
  Date: 2019/5/7
  Time: 14:46
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
            url: "${pageContext.request.contextPath }/evaluate/getAllById",
            type: "POST",
            data: {
                "id":id
            },
            success: function (data) {
                var $form = $('#updateForm');
                $form.find("input[name='id']").val(data.id);
                $form.find("input[name='stuname']").val(data.stuname);
                $form.find("input[name='elname']").val(data.elname);
                $form.find("input[name='publisher']").val(data.publisher);
            },
            error: function () {
                alert("失败")
            },
            dataType: "json"
        });
    });
    var stuname = $("input[name='stuname']").val().trim();
    var elname = $("input[name='elname']").val().trim();
    var publisher = $("input[name='publisher']").val().trim();
    $("#edit").click(function () {
        $.ajax({
            url: "${pageContext.request.contextPath }/evaluate/updateEvaluate",
            type: "POST",
            data: {
                "stuname": stuname,
                "elname": elname,
                "publisher": publisher,
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
    <title>修改评改</title>
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
                    <small>修改评价</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/evaluate/updateEvaluate" id="updateForm" method="post">
        <input type="hidden" name="id" id="id" value="${evaluate.id}"/>
        学生姓名：<input class="form-control" type="text" name="stuname"><br><br><br>
        评价名称：<input class="form-control" type="text" name="elname"><br><br><br>
        发布人：<input class="form-control" type="text" name="publisher"><br><br><br>
        <button class="btn btn-info" id="edit">修改</button>
    </form>

</div>