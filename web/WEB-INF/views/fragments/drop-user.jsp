<%--
  Created by IntelliJ IDEA.
  User: arch
  Date: 09.01.20
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="input-group">
    <select name="users">
        <option selected disabled>User</option>
        <c:forEach items="${users}" var="user">
            <option value="${user.name}">${user.name}</option>
        </c:forEach>
    </select>
</div>
</body>
</html>
