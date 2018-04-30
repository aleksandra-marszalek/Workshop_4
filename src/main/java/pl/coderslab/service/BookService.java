package pl.coderslab.service;


import pl.coderslab.model.Book;

import java.util.List;

public interface BookService {

    public List<Book> getList();
    public Book getBook(long id);
    public Book addBook( String isbn, String title, String author, String publisher, String type);
    public Book editBook(long id, String isbn, String title, String author, String publisher, String type );
    public Book deleteBook(long id );

}