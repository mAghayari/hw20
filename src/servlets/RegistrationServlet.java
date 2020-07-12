package servlets;

import dao.UserDao;
import model.User;
import service.UserFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "/registration")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        UserFactory userFactory = new UserFactory();
        User user = userFactory.userFactory(request);
        UserDao userDao = new UserDao();
        userDao.addUser(user);

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        ServletContext servletContext = getServletContext();
        List<User> onlineUsers = (List<User>) servletContext.getAttribute("onlineUsers");

        if (Objects.isNull(onlineUsers))
            onlineUsers = new ArrayList<>();

        onlineUsers.add(user);
        servletContext.setAttribute("onlineUsers", onlineUsers);
        response.sendRedirect("home.jsp");
    }
}