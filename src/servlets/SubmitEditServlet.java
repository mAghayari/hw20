package servlets;

import dao.BookDao;
import model.Book;
import service.BookFactory;

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

@WebServlet(name = "/editBook")
public class SubmitEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        if (Objects.nonNull(session)) {
            BookDao bookDao = new BookDao();
            BookFactory bookFactory = new BookFactory();
            Book book = bookFactory.bookFactory(request);
            book.setId(((Book) session.getAttribute("book")).getId());
            bookDao.editBook(book);

            writer.println("book edited successfully");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit.jsp");
            requestDispatcher.forward(request, response);
        } else {
            writer.println("Please Login First");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.include(request, response);
        }
    }
}