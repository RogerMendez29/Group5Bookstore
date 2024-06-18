package edu.fiu.Group5Bookstore.controller;

import edu.fiu.Group5Bookstore.DTOs.RatingPostDTO;
import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.model.Comment;
import edu.fiu.Group5Bookstore.model.Rating;
import edu.fiu.Group5Bookstore.model.User;
import edu.fiu.Group5Bookstore.service.BookService;
import edu.fiu.Group5Bookstore.service.CommentService;
import edu.fiu.Group5Bookstore.service.RatingService;
import edu.fiu.Group5Bookstore.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rating")

public class RatingController {

    private final BookService bookService;
    private final UserService userService;
    private final RatingService ratingService;

    public RatingController(RatingService ratingService, UserService userService, BookService bookService) {
        this.ratingService = ratingService;
        this.userService = userService;
        this.bookService = bookService;
    }

    //create a rating for a book by a user on a 5-star scale with a datestamp
    @PostMapping("/rating/{userId}/{bookId}")
    public ResponseEntity<Rating> createRating(@RequestBody RatingPostDTO ratingPostDTO) {
        User foundUser =  userService.findUser(ratingPostDTO.getUserId());
        Book foundBook = bookService.findBook(ratingPostDTO.getBookId());
        if (foundUser != null && foundBook != null) {
            Rating createRating = ratingService.createRating(foundBook, foundUser, ratingPostDTO.getRating(), ratingPostDTO.getDatestamp());
            return new ResponseEntity<Rating>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Rating>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/averageRating/{bookId}")
    public ResponseEntity<List<Rating>> getAverageRatingFromBookId(@PathVariable int bookId) {
        Book foundBook = bookService.findBook(bookId);
        if (foundBook != null) {
            double averageRating = ratingService.getAverageRatingFromBookId(foundBook.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
}

