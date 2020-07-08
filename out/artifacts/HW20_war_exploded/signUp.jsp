<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SignUp</title>
    <style type="text/css">
        <%@ include file="signUpStyle.css" %>
    </style>
</head>
<body>
<div class="signUpForm">
    <form action="${pageContext.request.contextPath}/registration" method="post">
        <h2>Sign up:</h2>

        <div class="inputBox">
            <label for="n1">FirstName:</label>
            <input type="text" name="fName" placeholder="firstName" id="n1">
        </div>

        <div class="inputBox">
            <label for="n2">LastName:</label>
            <input type="text" name="lName" placeholder="lastName" id="n2">
        </div>

        <div class="inputBox">
            <label for="n3">Email:</label>
            <input type="text" name="email" placeholder="email" id="n3">
        </div>

        <div class="inputBox">
            <label for="n4">Mobile Number:</label>
            <input type="text" name="mobile" placeholder="mobile Number" id="n4">
        </div>

        <div class="inputBox">
            <label for="n5">Age:</label>
            <input type="number" name="age" placeholder="age" id="n5">
        </div>

        <div class="inputBox">
            <label for="n6">UserName:</label>
            <input type="text" name="userName" placeholder="userName" id="n6">
        </div>

        <div class="inputBox">
            <label for="n7">Password:</label>
            <input type="password" name="password" placeholder="password" id="n7">
        </div>

        <div class="radioBox">
            <input type="radio" name="gender" value="Female" id="n8">
            <label for="n8">Female</label>
        </div>
        <div class="radioBox">
            <input type="radio" name="gender" value="Male">
            <label for="n8">Male</label>
        </div>

        <div>
            <input class="btn" type="submit" value="Sign Up">
        </div>
    </form>
</div>
</body>
</html>