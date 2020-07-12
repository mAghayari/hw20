<%@ page import="model.User" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>homepage</title>
    <style type="text/css">
        <%@ include file="homeStyle.css" %>
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
<form method="post">
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
        <a>Online Users:<%out.print(onlineUsers);%></a>
    </div>
</form>

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
</html>