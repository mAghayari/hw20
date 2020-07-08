<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SignIn</title>
    <style type="text/css">
        <%@ include file="loginStyles.css" %>
    </style>
</head>
<body>
<div class="loginForm">
    <form action="authentication" method="get">
        <h2 style="text-align: center;">Login:</h2>
        <div class="userNameBox">
            <i aria-hidden="true"></i>
            <input type="text" name="username" placeholder="userName" id="n1">
        </div>

        <div class="passwordBox">
            <i aria-hidden="true"></i>
            <input type="password" name="password" placeholder="password" id="n2">
        </div>

        <div>
            <input class="btn" type="submit" value="Login">
        </div>
    </form>
</div>
</body>
</html>