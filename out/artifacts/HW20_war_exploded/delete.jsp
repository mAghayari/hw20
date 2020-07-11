<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete book</title>
    <style type="text/css">
        <%@ include file="homeStyle.css" %>
        <%@ include file="deleteStyle.css" %>
        <%@ include file="addStyle.css" %>
    </style>
</head>
<body>
<% User user;
    String userName;%>
<% user = (User) session.getAttribute("user");
    userName = user.getUserName();%>
<div class="topnav">
    <%request.setAttribute("username", userName);%>
    <a href="home.jsp">Home</a>
    <a href="add.jsp">Add Book</a>
    <a class="active" href="delete.jsp">Delete Book</a>
    <a href="editForm.jsp">Edit Book</a>
    <a href="view.jsp">View Book</a>
    <a href="search.jsp">Search Book</a>
    <a href="${pageContext.request.contextPath}/logout">Logout</a>
    <a href="profile.jsp"><%out.print(userName);%></a>
</div>

<div class="deleteForm">
    <form action="${pageContext.request.contextPath}/deleteBook" method="post">
        <h2>Delete A Book</h2>

        <div class="inputBox">
            <label for="i">Book ID:</label>
            <input type="text" name="bookId" id="i" required>
        </div>

        <div>
            <input class="btn" type="submit" value="Delete">
        </div>

    </form>
</div>
</body>
</html>