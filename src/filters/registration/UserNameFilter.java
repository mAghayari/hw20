package filters.registration;

import service.UserValidation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "UserNameFilter")
public class UserNameFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (PrintWriter writer = resp.getWriter()) {
            String userName = req.getParameter("username");
            UserValidation userValidation = new UserValidation();
            if (userName.matches("[a-zA-z0-9._]{8}||" +
                    "[a-zA-z0-9._]{9}||" +
                    "[a-zA-z0-9._]{10}||" +
                    "[a-zA-z0-9._]{11}||" +
                    "[a-zA-z0-9._]{12}||")) {
                if (userValidation.UserNameHasBeenTaken(userName))
                    writer.println("<p>This userName has been taken</p>");
                else
                    chain.doFilter(req, resp);
            } else if (userName.length() < 8)
                writer.println("<p>userName is too short</p>");
            else if (userName.length() > 12)
                writer.println("<p>userName is too long</p>");
            else
                writer.println("<p>Invalid characters used in userName</p>");
        }
    }

    public void init(FilterConfig config) {

    }
}