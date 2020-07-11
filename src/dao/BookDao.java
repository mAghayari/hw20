package dao;

import model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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

    public Book findBookById(String bookId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Book book = (Book) session.get(Book.class.getName(), bookId);
        transaction.commit();
        session.close();
        return book;
    }

    public Book findBookByNameAndPublisher(String bookName, String publisher) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("From book b where b.name= :bookName And b.publisher= :publisher", Book.class);
        query.setParameter("bookName", bookName);
        query.setParameter("publisher", publisher);
        Book book = (Book) query.uniqueResult();
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
        session.update("book", book);
        transaction.commit();
        session.close();
    }

    public void updateBookCount(Book book) {
        Book desiredBook = findBookByNameAndPublisher(book.getName(), book.getPublisher());
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        desiredBook.setCount(book.getCount() + desiredBook.getCount());
        session.update("book", desiredBook);
        transaction.commit();
        session.close();
    }
}