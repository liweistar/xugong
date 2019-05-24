<%--
  Created by IntelliJ IDEA.
  User: 17489
  Date: 2019/5/6
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录界面</title>
</head>
<body>
<h1>管理员登录</h1>
<form method="post" action="/login/loginAdmin">
    用户名:<input type="text" name="username"/><br/>
    密码:<input type="password" name="password"/><br/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
