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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Home Page</title>
</head>
<body>

<h1>Welcome!</h1>
<jsp:include page="header.jsp"/>
<div class="container">
    <br/>
    <div class="row justify-content-center">
        <div class="col-12 col-md-10 col-lg-8">
            <form class="card card-sm">
                <div class="card-body row no-gutters align-items-center">
                    <div class="col">
                        <input class="form-control form-control-lg form-control-borderless" type="search" placeholder="Search task">
                    </div>
                    <div class="col-auto">
                        <button class="btn btn-lg btn-success" type="submit">Search</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th>Task ID</th>
        <th>Description</th>
        <th>Status</th>
        <th>Creation date</th>
        <th>Deadline</th>
        <th>Owner</th>
    </tr>
    </thead>

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
    <thead class="thead-dark">
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
    </thead>
</table>
<c:if test="${currentPage lt numOfPages}">
    <td><a href="home?page=${currentPage + 1}">Next</a></td>
</c:if>

</body>
</html>
