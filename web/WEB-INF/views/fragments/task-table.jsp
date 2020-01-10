<%--
  Created by IntelliJ IDEA.
  User: arch
  Date: 08.01.20
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th>Task ID</th>
        <th>Description</th>
        <th>Status</th>
        <th>Creation date</th>
        <th>Deadline</th>
        <th>Assignee</th>
        <th>Owner</th>
        <th>Edit</th>
        <th>Done</th>
        <th>Delete</th>
    </tr>
    </thead>
    <c:forEach var="task" items="${taskList}">
        <tr>
            <td>${task.taskID}</td>
            <td>${task.description}</td>
            <td>${task.status}</td>
            <td>${task.creationDate}</td>
            <td>${task.deadline}</td>
            <td>${task.assignee}</td>
            <td>${task.owner}</td>
            <form action="${pageContext.request.contextPath}/change-status" method="post">
                <th>
                    <a href="edit-task?taskId=${task.taskID}&description=${task.description}" class="nav-item nav-link">Edit</a>
                </th>
                <th>
                    <button type="submit" name="DONE" class="btn btn-success" value="${task.taskID}">DONE</button>
                </th>
                <th>
                    <button type="submit" name="DELETE" class="btn btn-danger" value="${task.taskID}">DELETE</button>
                </th>
            </form>
        </tr>
    </c:forEach>
</table>
</body>
</html>
