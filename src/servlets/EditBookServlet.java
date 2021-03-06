package servlets;

import dao.BookDao;
import model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "/edit")
public class EditBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);

        if (Objects.nonNull(session)) {
            if (Objects.nonNull(session.getAttribute("user"))) {
                String bookId = request.getParameter("bookId");
                BookDao bookDao = new BookDao();
                Book book = bookDao.findBookById(bookId);
                if (Objects.nonNull(book)) {
                    session.setAttribute("book", book);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("editPage.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    writer.println("Id Not Found");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("editForm.jsp");
                    requestDispatcher.forward(request, response);
                }
            } else {
                writer.println("Please Login First");
                response.sendRedirect("login.jsp");
            }
        } else {
            writer.println("Please Login First");
            response.sendRedirect("login.jsp");
        }
        writer.close();
    }
}