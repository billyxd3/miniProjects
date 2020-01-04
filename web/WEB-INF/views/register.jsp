<%--
  Created by IntelliJ IDEA.
  User: arch
  Date: 04.01.20
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<br><br>
<h1>Registration</h1>

<form action="${pageContext.request.contextPath}/register" method="post">
    User name: <input type="text" name="name">
    <br><br>
    Password: <input type="password" name="password">
    <br><br>
    <input type="submit" name="submit" value="Register"> <br>
</form>

</body>
</html>
