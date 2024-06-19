package edu.fiu.Group5Bookstore.controller;

import edu.fiu.Group5Bookstore.DTOs.CommentPostDTO;
import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.model.Comment;
import edu.fiu.Group5Bookstore.model.User;
import edu.fiu.Group5Bookstore.service.BookService;
import edu.fiu.Group5Bookstore.service.CommentService;
import edu.fiu.Group5Bookstore.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/comment")

public class CommentController {

    private final BookService bookService;
    private final UserService userService;
    private final CommentService commentService;

    public CommentController(BookService bookService, UserService userService, CommentService commentService) {
        this.bookService = bookService;
        this.userService = userService;
        this.commentService = commentService;
    }

    @PostMapping("/{userID}/{bookID}")
    public ResponseEntity<Comment> createComment(@RequestBody CommentPostDTO commentPostDTO) {
        User foundUser = userService.findUser(commentPostDTO.getUserId());
        Book foundBook = bookService.findBook(commentPostDTO.getBookId());
        if (foundUser != null && foundBook != null) {
            Comment createdComment = commentService.createComment(foundBook, foundUser, commentPostDTO.getComment(), commentPostDTO.getDatestamp());
            return new ResponseEntity<Comment>(createdComment, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{bookID}")
    public ResponseEntity<List<Comment>> getComments(@PathVariable int bookID) {
        Book foundBook = bookService.findBook(bookID);
        if (foundBook != null) {
            List<Comment> comments = commentService.getCommentFromBookId(foundBook.getId());
            return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
}
