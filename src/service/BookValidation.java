package service;

import dao.BookDao;

public class BookValidation {

    public boolean isExists(String bookName, String publisher) {
        BookDao bookDao = new BookDao();
        return bookDao.findBookByNameAndPublisher(bookName, publisher) != null;
    }
}
