<%@ page import="model.User" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>profile</title>
    <style type="text/css">
        <%@ include file="homeStyle.css" %>
        <%@ include file="editPage.css" %>
    </style>
</head>
<body>
<% if (Objects.nonNull(session)) {
    if (Objects.nonNull(session.getAttribute("user"))) {
        ServletContext servletContext = request.getServletContext();
        List<User> users = (List<User>) servletContext.getAttribute("onlineUsers");
        String onlineUsers = "";
        for (User user : users) {
            if (!onlineUsers.contains(user.getUserName()))
                onlineUsers += " " + user.getUserName() + "|";
        }
%>
<% User user;
    String userName;%>
<% user = (User) session.getAttribute("user");
    userName = user.getUserName();%>
<div class="topnav">
    <%request.setAttribute("username", userName);%>
    <a href="home.jsp">Home</a>
    <a href="add.jsp">Add Book</a>
    <a href="delete.jsp">Delete Book</a>
    <a href="editForm.jsp">Edit Book</a>
    <a href="view.jsp">View Book</a>
    <a href="search.jsp">Search Book</a>
    <a href="logout">Logout</a>
    <a class="active" href="profile.jsp"><%out.print(userName);%></a>
    <a>Online Users:<%out.print(onlineUsers);%></a>
</div>

<div class="editForm">
    <h2>User Info</h2>

    <div class="inputBox">
        <label for="f">First Name:</label>
        <input type="text" name="fName" id="f" value="<%out.print(user.getFirstName());%>" readonly>
    </div>

    <div class="inputBox">
        <label for="l">Last Name:</label>
        <input type="text" name="lName" id="l" value="<%out.print(user.getLastName());%>" readonly>
    </div>

    <div class="inputBox">
        <label for="m">Mobile Number:</label>
        <input type="text" name="mobile" id="m" value="<%out.print(user.getMobileNumber());%>" readonly>
    </div>

    <div class="inputBox">
        <label for="e">Email:</label>
        <input type="text" name="email" id="e" value="<%out.print(user.getEmail());%>" readonly>
    </div>

    <div class="inputBox">
        <label for="a">Age:</label>
        <input type="text" name="age" id="a" value="<%out.print(user.getAge());%>" readonly>
    </div>

    <div class="inputBox">
        <label for="un">UserName:</label>
        <input type="text" name="username" id="un" value="<%out.print(user.getUserName());%>" readonly>
    </div>
    </form>
</div>
<%
        } else {
            out.println("Please Login First");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request, response);
        }
    } else {
        out.println("Please Login First");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(request, response);
    }
%>
</body>