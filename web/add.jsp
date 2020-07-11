<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add book</title>
    <style type="text/css">
        <%@ include file="homeStyle.css" %>
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
    <a class="active" href="add.jsp">Add Book</a>
    <a href="delete.jsp">Delete Book</a>
    <a href="edit.jsp">Edit Book</a>
    <a href="view.jsp">View Book</a>
    <a href="search.jsp">Search Book</a>
    <a href="logout.jsp">Logout</a>
    <a href="profile.jsp"><%out.print(userName);%></a>
</div>

<div class="addForm">
    <form action="${pageContext.request.contextPath}/addBook" method="post">
        <h2>Add A Book</h2>

        <div class="inputBox">
            <label for="n">Book Name:</label>
            <input type="text" name="bookName" id="n" required>
        </div>

        <div class="inputBox">
            <label for="a">Author:</label>
            <input type="text" name="author" id="a" required>
        </div>

        <div class="inputBox">
            <label for="p">Publisher:</label>
            <input type="text" name="publisher" id="p" required>
        </div>


        <div class="inputBox">
            <label for="c">Count:</label>
            <input type="number" name="count" id="c" required>
        </div>

        <div class="inputBox">
            <label for="s">Subject:</label>
            <select class="dropdown" name="subject" id="s" required>
                <option value="Biography">Biography</option>
                <option value="Computers">Computers</option>
                <option value="Economy">Economy</option>
                <option value="Education">Education</option>
                <option value="Fiction">Fiction</option>
                <option value="Kids">Kids</option>
                <option value="Literature">Literature</option>
                <option value="Poetry">Poetry</option>
                <option value="Religion">Religion</option>
                <option value="Sports">Sports</option>
                <option value="Teens">Teens</option>
            </select>
        </div>

        <div class="inputBox">
            <label for="g">Age Group:</label>
            <select class="dropdown" name="ageGroup" id="g" required>
                <option value="A">A</option>
                <option value="B">B</option>
                <option value="C">C</option>
            </select>
        </div>

        <div>
            <input class="btn" type="submit" value="Add">
        </div>
    </form>
</div>
</body>
</html>