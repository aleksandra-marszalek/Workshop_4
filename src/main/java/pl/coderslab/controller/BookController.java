package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;
import pl.coderslab.service.MemoryBookService;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {


    @Autowired
    BookService bookService;

    @RequestMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming");
    }

    /**
     * Get all books
     * @return
     */
    @GetMapping("/")
    @ResponseBody
    public List<Book> getBooks() {
        return bookService.getList();
    }

    /**
     * Get single book
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ResponseBody
    public Book getBook(@PathVariable long id) {
        return bookService.getBook(id);
    }

    /**
     * add book ex. from form
     * @return
     */
    @PostMapping
    @ResponseBody
    public Book addBook(@RequestParam String isbn, @RequestParam String title,
                        @RequestParam String author, @RequestParam String publisher, @RequestParam String type) {
        return bookService.addBook(isbn, title, author, publisher, type);
    }

    /**
     * edit book ex. from form
     * @return
     */
    @PutMapping("/")
    @ResponseBody
    public Book editBook(@RequestParam long id, @RequestParam String isbn, @RequestParam String title,
                        @RequestParam String author, @RequestParam String publisher, @RequestParam String type) {
       return bookService.editBook(id, isbn, title, author, publisher, type);
    }

    /**
     * Delete single book
     * @param id
     * @return
     */
    @DeleteMapping("/")
    @ResponseBody
    public Book deleteBook(@RequestParam long id) {
        return bookService.deleteBook(id);
    }


}