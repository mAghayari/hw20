package servlets;

import dao.UserDao;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "/registration")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        User user = new User();
        user.setFirstName(request.getParameter("fName"));
        user.setLastName(request.getParameter("lName"));
        user.setEmail(request.getParameter("email"));
        user.setMobileNumber(request.getParameter("mobile"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setGender(request.getParameter("gender"));
        user.setUserName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));

        UserDao userDao = new UserDao();
        userDao.addUser(user);

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
        requestDispatcher.forward(request, response);
    }
}