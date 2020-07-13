package filters.registration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "NameFilter")
public class NameFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String firstName = req.getParameter("fName");
        String lastName = req.getParameter("lName");

        if (firstName.matches("[[a-zA-Z.]+(\\s)]+") && lastName.matches("[[a-zA-Z.]+(\\s)]+")) {
            chain.doFilter(req, resp);
        } else
            writer.println("FirstName and LastName must be alphabetic");
    }

    public void init(FilterConfig config) {

    }

}