<%--
  Created by IntelliJ IDEA.
  User: YMY
  Date: 2019/5/19
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/assets/js/Chart.min.js"></script>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url: "${pageContext.request.contextPath }/exam/examjson",
            type: "POST",
            data: {},
            success: function (data) {
                var result = "";
                $(data).each(function (i, el) {
                    result += "<tr>";
                    result += "<td>" + el.id + "</td>",
                        result += "<td>" + el.code + "</td>",
                        result += "<td>" + el.name + "</td>",
                        result += "<td>" + el.kemu + "</td>"
                        result += "<td>" + el.time + "</td>",
                        result += "<td>" + el.status + "</td>",
                        result += "<td><a href='${path}/exam/toUpdateExam?id=" + el.id + "'>更改</a>",
                        result += "<a href='${path}/exam/del?id=" + el.id + "'>删除</a></td>",
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

    function exportExamExcel() {
        $.post("/exam/excel", $(".exam-table-form").serialize(), function (r) {
            if (r.code === 0) {
                window.location.href = "/common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                alert("失败")
            }
        });
    }

</script>
<head>
    <title>成绩查询</title>
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
                    成绩查询
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>成绩查询</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${path}/exam/toAddExam">新增</a>
            <a class="btn btn-primary" href="javascript:void(0)" class="dropdown-item" data-table-action="excel"
               onclick="exportExamExcel()">
                Excel (.xlsx)
            报表</a>
        </div>
    </div>
    <div id="data-table_filter" class="dataTables_filter">
        <form class="exam-table-form">
        </form>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-responsive table-hover dataTable no-footer">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>考试科目</th>
                    <th>考试时间</th>
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
