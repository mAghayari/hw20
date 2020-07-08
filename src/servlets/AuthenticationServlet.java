package servlets;

import dao.UserDao;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
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

        if (Objects.nonNull(user)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.include(request, response);
            writer.println("<p>incorrect userName or password!</p>");
        }
        writer.close();
    }
}