<%--
  Created by IntelliJ IDEA.
  User: YMY
  Date: 2019/5/8
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
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
<a href="${pageContext.request.contextPath}/evaluate/allEvaluate">学生评价</a>

<a href="${pageContext.request.contextPath}/achievement/allAchievement">成绩管理</a>
<a href="${pageContext.request.contextPath}/mian/allMian">免修申请</a>
<a href="${pageContext.request.contextPath}/exam/allExam">考试安排</a>
<a href="${pageContext.request.contextPath}/rexam/allRexam">重考申请</a>
<a href="${pageContext.request.contextPath}/rebuild/allRebuild">重修申请</a>
</body>
</html>

