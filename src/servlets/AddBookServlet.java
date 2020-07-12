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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "/addBook")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);
        if (Objects.nonNull(session)) {
            if (Objects.nonNull(session.getAttribute("user"))) {
                BookDao bookDao = new BookDao();
                BookFactory bookFactory = new BookFactory();
                Book book = bookFactory.bookFactory(request);
                BookValidation bookValidation = new BookValidation();

                if (bookValidation.isExists(book.getName(), book.getPublisher())) {
                    bookDao.updateBookCount(book);
                    writer.println("Books count updated successfully");
                    response.sendRedirect("add.jsp");
                } else {
                    bookDao.addBook(book);
                    writer.println("Book added successfully");
                    response.sendRedirect("add.jsp");
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