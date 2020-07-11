package filters.registration;

import service.UserValidation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "EmailFilter")
public class EmailFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String email = req.getParameter("email");
        UserValidation userValidation = new UserValidation();
        if (email.matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")) {
            if (userValidation.emailHasBeenTaken(email))
                writer.println("<p>This Email has been registered before</p>");
            else
                chain.doFilter(req, resp);
        }
        writer.println("Invalid Email address");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("signUp.jsp");
        requestDispatcher.include(req, resp);
    }

    public void init(FilterConfig config) {

    }

}
