package filters.registration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "PasswordFilter")
public class PasswordFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String password = req.getParameter("password");
        if (password.matches("[a-zA-z0-9]{8}|" +
                "[a-zA-z0-9]{9}|" +
                "[a-zA-z0-9]{10}|" +
                "[a-zA-z0-9]{11}|" +
                "[a-zA-z0-9]{12}|" +
                "[a-zA-z0-9]{13}|" +
                "[a-zA-z0-9]{14}|" +
                "[a-zA-z0-9]{15}|" +
                "[a-zA-z0-9]{16}"))
            chain.doFilter(req, resp);
        else if (password.length() < 8)
            writer.println("<p>password is too short</p>");
        else if (password.length() > 16)
            writer.println("<p>password is too long</p>");
        else
            writer.println("<p>Invalid characters used in password</p>");
    }

    public void init(FilterConfig config) {

    }
}