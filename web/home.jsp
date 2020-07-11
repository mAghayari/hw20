<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>homepage</title>
    <style type="text/css">
        <%@ include file="homeStyle.css" %>
    </style>
</head>
<body>
<% User user;
    String userName;%>
<% user = (User) session.getAttribute("user");
    userName = user.getUserName();%>
<form method="get">
    <div class="topnav">
        <%request.setAttribute("username", userName);%>
        <a class="active" href="home.jsp">Home</a>
        <a href="add.jsp">Add Book</a>
        <a href="delete.jsp">Delete Book</a>
        <a href="editForm.jsp">Edit Book</a>
        <a href="view.jsp">View Book</a>
        <a href="search.jsp">Search Book</a>
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
        <a href="profile.jsp"><%out.print(userName);%></a>
    </div>
</form>
</body>
</html>