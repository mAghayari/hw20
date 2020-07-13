package filters.addbook;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "addBookFilter")
public class AuthorFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String author = req.getParameter("author");

        if (author.matches("[[a-zA-Z.]+(\\s)]+")) {
            chain.doFilter(req, resp);
        } else
            writer.println("Author's name must be alphabetic");
    }

    public void init(FilterConfig config) throws ServletException {

    }
}