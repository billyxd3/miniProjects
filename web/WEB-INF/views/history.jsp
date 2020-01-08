<%--
  Created by IntelliJ IDEA.
  User: arch
  Date: 05.01.20
  Time: 22:41
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
    <title>History</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<div class="row justify-content-left">
    <form class="card card-sm" action="${pageContext.request.contextPath}/delete-record" method="post">
        <button type="submit" name="CLEAR" class="btn btn-danger" value="${history_record.id}">Clear history</button>
    </form>

    <form class="card card-sm" action="${pageContext.request.contextPath}/history" method="post">
        <select class="selectpicker" data-style="btn-info" name="period">
            <option value="today">Today</option>
            <option value="last week">Last week</option>
            <option value="last month">Last month</option>
            <option value="last year">Last year</option>
            <option value="all">All</option>
        </select>
        <button type="submit" class="btn btn-info">Show</button>
    </form>
</div>

<table class="table">
    <thead class="thead-dark">
    <tr>
        <th>ID</th>
        <th>Task</th>
        <th>Modified Date</th>
        <th>Status</th>
        <th>Delete</th>
    </tr>
    </thead>
    <c:forEach var="history_record" items="${historyList}">
        <tr>
            <td>${history_record.id}</td>
            <td>${history_record.task}</td>
            <td>${history_record.modifiedDate}</td>
            <td>${history_record.status}</td>
            <form action="${pageContext.request.contextPath}/delete-record" method="post">
                <th>
                    <button type="submit" name="DELETE" class="btn btn-danger" value="${history_record.id}">DELETE
                    </button>
                </th>
            </form>
        </tr>
    </c:forEach>
</table>

<c:if test="${currentPage != 1}">
    <td><a href="history?page=${currentPage - 1}">Previous</a></td>
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
                    <td><a href="history?page=${i}">${i}</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
    </thead>
</table>
<c:if test="${currentPage lt numOfPages}">
    <td><a href="history?page=${currentPage + 1}">Next</a></td>
</c:if>

</body>
</html>
