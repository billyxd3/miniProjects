<%--
  Created by IntelliJ IDEA.
  User: arch
  Date: 04.01.20
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-form-title" style="background-image: url(/WEB-INF/views/images/bg-01.jpg);">
					<span class="login100-form-title-1">
						To Do List
					</span>
            </div>

            <form class="login100-form validate-form action="
            ${pageContext.request.contextPath}/main" method="post">
            <input class="inputS" type="submit" name="submitLogin" value="Sign in"> <br>
            <input class="inputS" type="submit" name="submitRegistration" value="Sign up"> <br>
            </form>

        </div>
    </div>
</div>
</body>
</html>
