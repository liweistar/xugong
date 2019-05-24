<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 17489
  Date: 2019/5/6
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员界面</title>
</head>
<body>
<h1>一卡通管理</h1>
<%--<c:forEach items="${list1}" var="a" varStatus="status">--%>
<%--    <td>${a.username}</td>--%>
<%--</c:forEach>--%>

<a href="${pageContext.request.contextPath}/evaluate/evaluate?code=${student1.username}">学生评价</a>
<a href="${pageContext.request.contextPath}/achievement/achievement?code=${student1.username}">查看成绩</a>
<a href="${pageContext.request.contextPath}/mian/mian?code=${student1.username}">免修</a>
<a href="${pageContext.request.contextPath}/exam/exam?code=${student1.username}">考试安排查询</a>
<a href="${pageContext.request.contextPath}/rexam/rexam?code=${student1.username}">重考</a>
<a href="${pageContext.request.contextPath}/rebuild/rebuild?code=${student1.username}">重修申请</a>
</body>
</html>
