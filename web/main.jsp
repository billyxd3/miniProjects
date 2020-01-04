<%--
  Created by IntelliJ IDEA.
  User: arch
  Date: 04.01.20
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<h1>To Do List</h1>
<form action="${pageContext.request.contextPath}/main" method="post">
    <input type="submit" name="submitLogin" value="Sign in"> <br>
    <input type="submit" name="submitRegistration" value="Sign up"> <br>
</form>
</body>
</html>
