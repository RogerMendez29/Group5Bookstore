package edu.fiu.Group5Bookstore.controller;

import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.service.BookService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Void> createBook(@RequestBody Book book) {
        bookService.createBook(book);
        return ResponseEntity.status(201).build();

    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
        Book book = bookService.getBookByIsbn(isbn);
        if (book != null) {
            return ResponseEntity.ok(book);
        }

        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

}