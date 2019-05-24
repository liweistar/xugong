<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/5/12
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
<script>
    $(function() {
        $("#content").hide();
        $("a:eq(0)").click(function () {
            $("#content").hide();
            $.post("course/tcourse", function (data) {
                var result = "";
                for (var i = 0; i < data.length; i++) {
                    result += "<tr>";
                    result += "<td>" + data[i].coursecode + "</id>";
                    result += "<td>" + data[i].coursename + "</id>";
                    result += "<td>" + data[i].courseteacher + "</id>";
                    result += "<td>" + data[i].courselocaltion + "</id>";
                    result += "<td>" + data[i].coursetime + "</id>";
                    result += "<td>" + data[i].coursetype + "</id>";
                    result += "<td>" + data[i].selcount + "</id>";
                    result += "</tr>";
                }
                $("#mytbody").html(result);
            })
        })
        $("a:eq(1)").click(function () {
            $("#content").show();
            $.post("selcontent", function (data) {
                var result = "";
                for (var i = 0; i < data.length; i++) {
                    result += "<tr>";
                    result += "<td>" + data[i].teaname+":" + "</id>";
                    result += "<td>" + data[i].content + "</id>";
                    result += "</tr>";
                }
                $("#mytbody").html(result);
            })
        })
        $("#sub").click(function () {
            $("#content").hide();
            $.post("selcontent", function (data) {
                var result = "";
                for (var i = 0; i < data.length; i++) {
                    result += "<tr>";
                    result += "<td>" + data[i].teaname+":" + "</id>";
                    result += "<td>" + data[i].content + "</id>";
                    result += "</tr>";
                }
                $("#mytbody").html(result);
            })
        })
        return false;
    })
</script>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td><a>授课信息</a></td>
        <td><a>教师反馈</a></td>
    </tr>
    <tbody id="mytbody"></tbody>
</table>

<div id="content">
    <form action="inscon" method="post">
    反馈信息：<input type="text" name="content" id="inp">
        <input type="submit" value="提交" id="sub">
    </form>
</div>
</body>
</html>
