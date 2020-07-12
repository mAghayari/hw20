<%@ page import="model.User" %>
<%@ page import="model.Book" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>book info</title>
    <style type="text/css">
        <%@ include file="homeStyle.css" %>
        <%@ include file="bookInfoStyle.css" %>
        <%@ include file="addStyle.css" %>
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
    Book book;
    String userName;%>
<% user = (User) session.getAttribute("user");
    book = (Book) request.getAttribute("book");
    userName = user.getUserName();%>
<div class="topnav">
    <%request.setAttribute("username", userName);%>
    <a href="home.jsp">Home</a>
    <a href="add.jsp">Add Book</a>
    <a href="delete.jsp">Delete Book</a>
    <a href="editForm.jsp">Edit Book</a>
    <a href="view.jsp">View Book</a>
    <a class="active" href="search.jsp">Search Book</a>
    <a href="${pageContext.request.contextPath}/logout">Logout</a>
    <a href="profile.jsp"><%out.print(userName);%></a>
    <a>Online Users:<%out.print(onlineUsers);%></a>
</div>
<div class="block">
    <h2>Book Info</h2>
    <div>
        <table>
            <tr>
                <td class="topic">Name</td>
                <td class="value"><%out.print(book.getName());%></td>
            </tr>
            <tr>
                <td class="topic">Author</td>
                <td class="value"><%out.print(book.getAuthor());%></td>
            </tr>
            <tr>
                <td class="topic">Publisher</td>
                <td class="value"><%out.print(book.getPublisher());%></td>
            </tr>
            <tr>
                <td class="topic">Subject</td>
                <td class="value"><%out.print(book.getSubject());%></td>
            </tr>
            <tr>
                <td class="topic">AgeGroup</td>
                <td class="value"><%out.print(book.getAgeGroup());%></td>
            </tr>
            <tr>
                <td class="topic">Count</td>
                <td class="value"><%out.print(book.getCount());%></td>
            </tr>
        </table>
    </div>
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