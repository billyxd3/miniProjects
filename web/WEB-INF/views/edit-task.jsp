<%--
  Created by IntelliJ IDEA.
  User: arch
  Date: 10.01.20
  Time: 13:38
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
    <title>Edit task</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<br>
<div class="row justify-content-center">
    <div class="col-12 col-md-10 col-lg-8">
        <form action="${pageContext.request.contextPath}/edit-task" method="post">
            <div class="form-group row">
                <label for="staticEmail" class="col-sm-2 col-form-label">Old description</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="staticEmail"
                           value="${pageContext.request.getParameter("description")}">
                </div>
            </div>
            <div class="form-group row">
                <label for="inputDescription" class="col-sm-2 col-form-label">New Description</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" id="inputDescription"
                           name="newDescription" placeholder="Description">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Assignee</label>
                <div class="col-sm-10">
                    <jsp:include page="fragments/drop-user.jsp"/>
                </div>
            </div>
            <div class="row justify-content-center">
                <button type="submit" name="confirm" class="btn btn-success btn-lg"
                        value="${pageContext.request.getParameter("taskId")}">Confirm
                </button>
                <button type="button" class="btn btn-light btn-lg" disabled></button>
                <button type="submit" class="btn btn-primary btn-lg" name="cancel" value="cancel">Cancel</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
