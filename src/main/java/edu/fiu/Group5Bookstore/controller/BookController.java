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

import java.util.InputMismatchException;
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
        if(!byGenre.isEmpty())
            return new ResponseEntity<>(byGenre, HttpStatus.OK);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/publisher/{publisher}")
    public ResponseEntity<List<Book>> getBookByPublisher(@PathVariable String publisher)
    {
        List<Book> byPublisher = bookService.getBookByPublisher(publisher);
        if(!byPublisher.isEmpty())
            return new ResponseEntity<>(byPublisher, HttpStatus.OK);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/top")
    public ResponseEntity<List<Book>> getTopSoldBooks()
    {
        List<Book> byTopSold = bookService.getTopSoldBooks();
        if(!byTopSold.isEmpty())
            return new ResponseEntity<>(byTopSold, HttpStatus.OK);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<Book>> getBookByAverageRating(@PathVariable Double rating)
    {
        List<Book> byRating = bookService.getBookByRating(rating);
        if (!byRating.isEmpty())
            return new ResponseEntity<>(byRating, HttpStatus.OK);
        else
            return ResponseEntity.notFound().build();
    }

    @PatchMapping("/discount")
    public ResponseEntity<?> applyDiscountByPublisher(@RequestBody BookDiscountPatchDTO bookDiscountPatchDTO)
    {
        try {
            if(bookDiscountPatchDTO.getDiscount() >= .95 || bookDiscountPatchDTO.getDiscount() <= 0)
                throw new InputMismatchException();
            List<Book> publishers = bookService.getBookByGenre(bookDiscountPatchDTO.getPublisher());
            if (publishers.isEmpty())
                return ResponseEntity.notFound().build();
            bookService.applyDiscount(bookDiscountPatchDTO.getPublisher(), bookDiscountPatchDTO.getDiscount());
            String returnMessage = (bookDiscountPatchDTO.getDiscount() * 100) + "% discount was applied to " + bookDiscountPatchDTO.getPublisher() + "'s books.";
            return new ResponseEntity<>(returnMessage, HttpStatus.OK);
        }
        catch (InputMismatchException e) {
            String returnMessage = "The discount applied must be in the range (0.0,0.95) exclusive.";
            return new ResponseEntity<>(returnMessage, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

}