package servlets;

import dao.BookDao;
import model.Book;
import service.BookFactory;
import service.BookValidation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/addBook")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        BookDao bookDao = new BookDao();
        BookFactory bookFactory = new BookFactory();
        Book book = bookFactory.bookFactory(request);
        BookValidation bookValidation = new BookValidation();

        if (bookValidation.isExists(book.getName(), book.getPublisher())) {
            bookDao.updateBookCount(book);
            writer.println("<p>Books count updated successfully</p>");

        } else {
            bookDao.addBook(book);
            writer.println("<p>Book added successfully</p>");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("add.jsp");
        requestDispatcher.forward(request, response);

    }
}
