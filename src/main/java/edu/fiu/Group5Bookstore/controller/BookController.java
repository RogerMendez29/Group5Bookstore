package edu.fiu.Group5Bookstore.controller;

import edu.fiu.Group5Bookstore.DTOs.BookDiscountPatchDTO;
import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.model.CartItem;
import edu.fiu.Group5Bookstore.model.User;
import edu.fiu.Group5Bookstore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@RestController
@RequestMapping("/api/book")
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

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Book>> getBookByGenre(@PathVariable String genre) {
        List<Book> byGenre = bookService.getBookByGenre(genre);
        return new ResponseEntity<>(byGenre, HttpStatus.OK);
    }

    @GetMapping("/publisher/{publisher}")
    public ResponseEntity<List<Book>> getBookByPublisher(@PathVariable String publisher)
    {
        List<Book> byPublisher = bookService.getBookByPublisher(publisher);
        return new ResponseEntity<>(byPublisher, HttpStatus.OK);
    }

    @GetMapping("/top")
    public ResponseEntity<List<Book>> getTopSoldBooks()
    {
        List<Book> byTopSold = bookService.getTopSoldBooks();
        return new ResponseEntity<>(byTopSold, HttpStatus.OK);
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<Book>> getBookByAverageRating(@PathVariable Double rating)
    {
        List<Book> byRating = bookService.getBookByRating(rating);
        return new ResponseEntity<>(byRating, HttpStatus.OK);
    }

    @PatchMapping("/discount")
    public ResponseEntity<?> applyDiscountByPublisher(@RequestBody BookDiscountPatchDTO bookDiscountPatchDTO)
    {
        bookService.applyDiscount(bookDiscountPatchDTO.getPublisher(), bookDiscountPatchDTO.getDiscount());
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

}