package servlets;

import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);
        ServletContext servletContext = getServletContext();

        if (Objects.nonNull(session)) {
            User user = (User) session.getAttribute("user");
            List<User> users = (List<User>) servletContext.getAttribute("onlineUsers");
            if (Objects.nonNull(users)) {
                if (users.contains(user)) {
                    users.remove(user);
                    servletContext.setAttribute("onlineUsers", users);
                    session.removeAttribute("user");
                    session.removeAttribute("book");
                    session.invalidate();
                }
            }
        }
        response.sendRedirect("login.jsp");
        writer.println("You are successfully logged out!");
        writer.close();
    }
}