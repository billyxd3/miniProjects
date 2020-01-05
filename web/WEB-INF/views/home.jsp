<%--
  Created by IntelliJ IDEA.
  User: arch
  Date: 04.01.20
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h1>Welcome!</h1>
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <th>Task ID</th>
            <th>Description</th>
            <th>Status</th>
            <th>Creation date</th>
            <th>Deadline</th>
            <th>Owner</th>
        </tr>

        <c:forEach var="task" items="${taskList}">
            <tr>
                <td>${task.taskID}</td>
                <td>${task.description}</td>
                <td>${task.status}</td>
                <td>${task.creationDate}</td>
                <td>${task.deadline}</td>
                <td>${task.owner}</td>
            </tr>
        </c:forEach>
    </table>

    <c:if test="${currentPage != 1}">
        <td><a href="home?page=${currentPage - 1}">Previous</a></td>
    </c:if>
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <c:forEach begin="1" end="${numOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="home?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
    <c:if test="${currentPage lt numOfPages}">
        <td><a href="home?page=${currentPage + 1}">Next</a></td>
    </c:if>

</body>
</html>
