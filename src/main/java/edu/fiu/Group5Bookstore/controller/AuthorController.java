package edu.fiu.Group5Bookstore.controller;

import edu.fiu.Group5Bookstore.model.Author;
import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Void> createAuthor(@RequestBody Author author) {
        authorService.createAuthor(author);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") int id) {
        Author author = authorService.getAuthorById(id);
        if (author != null) {
            return ResponseEntity.ok(author);
        }

        else {
            return ResponseEntity.notFound().build();
        }
    }



    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

    public ResponseEntity<List<Book>> getBooksByAuthorId(@PathVariable int authorId) {
        List<Book> books = authorService.getBooksByAuthorId(authorId);
        return ResponseEntity.ok(books);
    }
}
