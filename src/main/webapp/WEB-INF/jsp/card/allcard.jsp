<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 17489
  Date: 2019/5/7
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<head>
    <title>一卡通充值</title>
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
                    <small>一卡通充值</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>专业</th>
                    <th>金额</th>
                    <th>状态</th>
                    <th>充值时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="list"></tbody>

                <input type="hidden" name="code" value="${card.code}">

            </table>
        </div>
    </div>
    <%--    </form>--%>
    <script type="text/javascript">

        $(function aa() {
                var code = $("input[name='code']").val().trim();
                $.ajax({

                    url: "${pageContext.request.contextPath }/card/card1",
                    type: "POST",
                    dataType: 'json',
                    data: {
                        "code":code
                    },
                    success: function (data) {
                        var result = "";

                        $.each(data, function (i, el) {
                            result += "<tr>";
                            result += "<td>" +code + "</td>";
                            result += "<td>" + el.name+ "</td>";
                            result += "<td>" + el.speciality + "</td>";
                            result += "<td>" + el.money + "</td>";
                            result += "<td>" + el.power + "</td>";
                            result += "<td>" + el.date + "</td>";
                            result +=  "<td><input type='text' name='qian' placeholder='请充值' id='qian'>";
                            result +=  " <input type='button' class='btn btn-primary' value='充值' id='cz'/></td>";

                        });
                        $("#list").html(result);
                    },
                    error: function () {
                        alert("失败")
                    }
                })
            },
            $("#click1").click(function () {

                window.location.href="${pageContext.request.contextPath}/lostcard/back";
            }),

            $("#cz").die('click').live('click', function() {
                var code = $("input[name='code']").val().trim();
                var qian = $("input[name='qian']").val().trim();
                $.ajax({

                    url: "${pageContext.request.contextPath}/card/chongzhi",
                    type: "POST",
                    data: {

                        "code": code,
                         "qian": qian
                    },
                    dateType:"json",
                    success: function (data) {

                        var result = "";

                        $.each(data, function (i, el) {
                            result += "<tr>";
                            result += "<td>" +code + "</td>";
                            result += "<td>" + el.name+ "</td>";
                            result += "<td>" + el.speciality + "</td>";
                            result += "<td>" + el.money + "</td>";
                            result += "<td>" + el.power + "</td>";
                            result += "<td>" + el.date + "</td>";
                            result +=  "<td><input type='text' name='qian' placeholder='请充值' id='qian'>";
                            result +=  " <input type='button' class='btn btn-primary' value='充值' id='cz'/></td>";

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
