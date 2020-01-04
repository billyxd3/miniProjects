<%--
  Created by IntelliJ IDEA.
  User: arch
  Date: 03.01.20
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>

  <br><br>
  <h1>Login</h1>
  <c:if test="${error ne null}">
    <p>
      <font color="red">${error}</font>
    </p>
  </c:if>
  <form action="${pageContext.request.contextPath}/login" method="post">
    User name: <input type="text" name="name">
    <br><br>
    Password: <input type="password" name="password">
    <br><br>
    <input type="submit" name="submit" value="Sign in"> <br>
  </form>

  </body>
</html>
