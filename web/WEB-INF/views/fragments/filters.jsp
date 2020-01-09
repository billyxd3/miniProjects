<%--
  Created by IntelliJ IDEA.
  User: arch
  Date: 09.01.20
  Time: 17:45
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
    <title></title>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <form action="${pageContext.request.contextPath}/home" method="post">
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="filterBy" value="user">
                <jsp:include page="drop-user.jsp"/>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="filterBy" value="date">
                <div class="input-group">
                    <input placeholder="FROM" class="form-control" type="text" name="from" onfocus="(this.type='date')"
                           onblur="(this.type='text')">
                    <input placeholder="To" class="form-control" type="text" name="to" onfocus="(this.type='date')"
                           onblur="(this.type='text')">
                </div>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="filterBy" value="status">
                <select class="selectpicker" data-style="btn-info" name="statuses">
                    <option selected disabled>Status</option>
                    <option value="Created">Created</option>
                    <option value="In Progress">In Progress</option>
                    <option value="Done">Done</option>
                    <option value="Failed">Failed</option>
                </select>
            </div>
            <button type="submit" class="btn btn-info">Filter</button>
        </form>
    </div>
</div>
</body>
</html>
