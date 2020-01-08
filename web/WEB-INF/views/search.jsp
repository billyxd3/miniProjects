<%--
  Created by IntelliJ IDEA.
  User: arch
  Date: 08.01.20
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Home Page</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<jsp:include page="fragments/task-table.jsp"/>

<c:if test="${currentPage != 1}">
    <td><a href="search-task?page=${currentPage - 1}">Previous</a></td>
</c:if>
<table border="1" cellpadding="5" cellspacing="5">
    <thead class="thead-dark">
    <tr>
        <c:forEach begin="1" end="${numOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <td>${i}</td>
                </c:when>
                <c:otherwise>
                    <td><a href="search-task?page=${i}">${i}</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
    </thead>
</table>
<c:if test="${currentPage lt numOfPages}">
    <td><a href="search-task?page=${currentPage + 1}">Next</a></td>
</c:if>
</body>
</html>
