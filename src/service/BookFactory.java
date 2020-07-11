package service;

import model.Book;

import javax.servlet.ServletRequest;

public class BookFactory {
    public Book bookFactory(ServletRequest request) {
        Book book = new Book();
        book.setName(request.getParameter("bookName"));
        book.setAuthor(request.getParameter("author"));
        book.setPublisher(request.getParameter("publisher"));
        book.setSubject(request.getParameter("subject"));
        book.setAgeGroup(request.getParameter("ageGroup").toUpperCase());
        book.setCount(Integer.parseInt(request.getParameter("count")));
        return book;
    }
}
