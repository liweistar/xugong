<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 17489
  Date: 2019/5/7
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>

    <script>
    $(function aa() {
        var code = $("input[name='code']").val().trim();
        $.ajax({
            url: "${pageContext.request.contextPath }/lostcard/status",
            type: "POST",
            dataType: 'json',
            data: {
                "code":code
            },
            success: function (data) {
                var result = "";
                $.each(data, function (i, el) {
                    result += "<tr>";
                    result += "<td>" + el.code + "</td>";
                    result += "<td>" + el.name + "</td>";
                    result += "<td>" + el.number + "</td>"
                    result += "<td><img class='pimg' src='/pic/"+el.img+"' width=100 height=100></td>";
                    result += "<td>" + el.handle + "</td>";
                    result += "<td>" + el.reviewe + "</td>";
                    result += "<td>" + el.recive + "</td>";
                    result += "<td><a href='${pageContext.request.contextPath}/lostcard/delete?code=" + el.code + "'>完成</a></td>";

                    result += "</tr>";
                });
                $("#list").html(result);
            },
            error: function () {
                alert("失败")
            },

        })
    })
</script>
<head>
    <title>填写挂失表</title>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 引入 Bootstrap -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>填写挂失表</small>
                </h1>
            </div>
        </div>
    </div>
<form action="${pageContext.request.contextPath}/lostcard/lostcard" method="post" enctype="multipart/form-data">
    <tr>
        <td>学号:<input type="text" name="code" value=${sessionScope.lost.codeid}></td>

        <td>姓名:<input type="text" name="name" value="${sessionScope.lost.name}"></td>

        <td>手机号:<input type="text" name="number" value="${sessionScope.lost.number}"></td><br><br><br>

        <td>上传身份证:<div><input type="file"  name="filename"></div></td>
    </tr>
    <br>
    <input type="submit" class="btn btn-primary" value="提交">
</form>
<div>${success}</div>
<div>${exist}</div>
<div>${fall2}</div>
<div>${shibai}</div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>补办状态查询</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
<table class="table table-hover table-striped">
    <thead>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>手机号</th>
        <th>身份证照片</th>
        <th>处理</th>
        <th>审核</th>
        <th>可否领取</th>
        <th>操作</th>
    </tr></thead>
    <tbody id="list"></tbody></table>
        </div>
    </div>
</div>
</body>
<script>
    $("#click1").click(function () {

        window.location.href="${pageContext.request.contextPath}/lostcard/back";
    })
</script>
</html>
