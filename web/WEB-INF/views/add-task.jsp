<%--
  Created by IntelliJ IDEA.
  User: arch
  Date: 05.01.20
  Time: 22:42
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
    <link rel="stylesheet" type="text/css" href="css/addForm.css">
    <title>Add task</title>
</head>
<body>
<div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
    <jsp:include page="fragments/header.jsp"/>
    <div class="wrapper wrapper--w960">
        <div class="card card-2">
            <div class="card-body">
                <h2 class="title">Task Info</h2>
                <c:if test="${error ne null}">
                    <p class="text-center">
                        <br><br>
                        <font color="red">${error}</font>
                    </p>
                </c:if>
                <form action="${pageContext.request.contextPath}/add-task" method="POST">
                    <div class="input-group">
                        <input class="input--style-2" type="text" placeholder="Description" name="description">
                    </div>
                    <div class="row row-space">
                        <div class="col-md-4">
                            <div class="input-group">
                                <input class="input--style-2 js-datepicker" type="text"
                                       onfocus="(this.type='date')" placeholder="Deadline" name="deadline">
                            </div>
                        </div>
                    </div>
                    <div class="input-group">
                        <select name="users">
                            <option selected disabled>Assignee</option>
                            <c:forEach items="${users}" var="user">
                                <option value="${user.name}">${user.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="p-t-30">
                        <button class="btn btn--radius btn--green" type="submit">Add</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
