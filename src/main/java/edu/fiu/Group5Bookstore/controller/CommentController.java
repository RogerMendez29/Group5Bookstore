package edu.fiu.Group5Bookstore.controller;

import edu.fiu.Group5Bookstore.DTOs.CommentPostDTO;
import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.model.Comment;
import edu.fiu.Group5Bookstore.model.User;
import edu.fiu.Group5Bookstore.repository.BookRepository;
import edu.fiu.Group5Bookstore.repository.UserRepository;
import edu.fiu.Group5Bookstore.service.BookService;
import edu.fiu.Group5Bookstore.service.CommentService;
import edu.fiu.Group5Bookstore.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/comment")

public class CommentController {

    private final CommentService commentService;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public CommentController(CommentService commentService, UserRepository userRepository, BookRepository bookRepository) {
        this.commentService = commentService;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @PostMapping("/create") // done works as intended
    public ResponseEntity<Comment> createComment(@RequestBody CommentPostDTO commentPostDTO) {

        User userId =userRepository.findById(commentPostDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + commentPostDTO.getUserId()));

        Book bookId = bookRepository.findById(commentPostDTO.getBookId())
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + commentPostDTO.getBookId()));

        Comment comment = new Comment(bookId, userId, commentPostDTO.getComment(), commentPostDTO.getDatestamp());
        Comment savedComment = commentService.createComment(comment);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedComment);
    }

    @GetMapping("/{bookId}") //looks up comments associated with certain book ID
    public ResponseEntity<List<Comment>> getComments(@PathVariable int bookId) {

        List<Comment> comments = commentService.getCommentByBookId(bookId);

        if (!comments.isEmpty()) {
            return ResponseEntity.ok(comments);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
