package pl.coderslab.controller;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class MemoryBookService {
    private List<Book> list;

    public MemoryBookService() {
    list = new ArrayList<>();
    list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
            "Helion", "programming"));
    list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
            "Sierra Kathy, Bates Bert", "Helion", "programming"));
    list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
            "Cay Horstmann, Gary Cornell", "Helion", "programming"));
}
    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public Book addBook (String isbn, String title, String author, String publisher, String type) {
        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setType(type);
        List<Book> books = getList();
        books.add(book);
        return book;
    }

    public Book getBook(long id) {
        List<Book> books = getList();
        Book book = new Book();
        for (Book b: books) {
            if(b.getId()==id) {
                book=b;
            }
        }
        return book;
    }

    public Book editBook(long id, String isbn, String title, String author, String publisher, String type) {
        List<Book> books = getList();
        Book book = getBook(id);
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setType(type);
        books.add(book);
        return book;
    }

    public Book deleteBook (long id) {
        List<Book> books = getList();
        Book book = getBook(id);
        books.remove(book);
        return book;
    }




}