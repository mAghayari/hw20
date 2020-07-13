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
    <form action="registration" method="post">
        <h2>Sign up:</h2>

        <div class="inputBox">
            <label for="n1">FirstName:</label>
            <input type="text" name="fName" placeholder="firstName" id="n1" required>
        </div>

        <div class="inputBox">
            <label for="n2">LastName:</label>
            <input type="text" name="lName" placeholder="lastName" id="n2" required>
        </div>

        <div class="inputBox">
            <label for="n3">Email:</label>
            <input type="text" name="email" placeholder="email" id="n3" required>
        </div>

        <div class="inputBox">
            <label for="mobile">Mobile Number: (without 0)</label>
            <input type="text" name="mobile" placeholder="mobile Number" id="mobile" required>
        </div>

        <div class="inputBox">
            <label for="age">Age:</label>
            <input type="number" name="age" placeholder="age" id="age" required>
        </div>

        <div class="inputBox">
            <label for="userName">UserName: [a-zA-Z-0-9-_-.], 7< length <13</label>
            <input type="text" name="username" placeholder="userName" id="userName" required>
        </div>

        <div class="inputBox">
            <label for="password">Password: [a-z-A-Z-0-9], 7< length <17</label>
            <input type="password" name="password" placeholder="password" id="password" required>
        </div>

        <div class="radioBox">
            <input type="radio" name="gender" value="Female" id="female" required>
            <label for="female">Female</label>
        </div>

        <div class="radioBox">
            <input type="radio" name="gender" value="Male" id="male" required>
            <label for="male">Male</label>
        </div>

        <div>
            <input class="btn" type="submit" value="Sign Up">
        </div>
    </form>
</div>
</body>
</html>