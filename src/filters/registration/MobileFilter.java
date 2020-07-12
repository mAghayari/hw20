package filters.registration;

import service.UserValidation;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MobileFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String mobile = req.getParameter("mobile");
        UserValidation userValidation = new UserValidation();
        if (mobile.matches("9((0[1-3]|5)|(1[0-9])|(2[0-2])|(3(1|[3-9]))|(9[0-1]))[0-9]{7}")) {
            if (userValidation.mobileHasBeenTaken(mobile))
                writer.println("<p>This mobile number has been registered before</p>");
            else
                chain.doFilter(req, resp);
        } else
            writer.println("Invalid mobile number");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("signUp.jsp");
        requestDispatcher.include(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
