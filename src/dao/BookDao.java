package dao;

import model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class BookDao {
    SessionFactory sessionFactory = new Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();

    public void addBook(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
    }

    public Book findBook(String bookId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Book book = (Book) session.get(Book.class.getName(), bookId);
        transaction.commit();
        session.close();
        return book;
    }

    public List<Book> getAllBooks() {
        List<Book> books;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        books = session.createQuery("From book").getResultList();
        transaction.commit();
        session.close();
        return books;
    }

    public void deleteBook(String bookId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Book book = (Book) session.get(Book.class.getName(), bookId);
        if (book != null)
            session.delete(book);
        transaction.commit();
        session.close();
    }

    public void editBook(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(book);
        transaction.commit();
        session.close();
    }
}