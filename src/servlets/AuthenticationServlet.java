package servlets;

import dao.UserDao;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "/authentication")
public class AuthenticationServlet extends javax.servlet.http.HttpServlet {

    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userDao.findUser(userName, password);

        if (!Objects.equals(user, null)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            ServletContext servletContext = getServletContext();
            List<User> onlineUsers = (List<User>) servletContext.getAttribute("onlineUsers");

            if (Objects.isNull(onlineUsers))
                onlineUsers = new ArrayList<>();

            onlineUsers.add(user);
            servletContext.setAttribute("onlineUsers", onlineUsers);
            response.sendRedirect("home.jsp");
        } else {
            writer.println("<p>incorrect userName or password!</p>");
            response.sendRedirect("login.jsp");
        }
        writer.close();
    }
}