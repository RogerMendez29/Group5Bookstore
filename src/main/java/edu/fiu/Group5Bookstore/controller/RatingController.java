package edu.fiu.Group5Bookstore.controller;

import edu.fiu.Group5Bookstore.DTOs.RatingPostDTO;
import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.model.Rating;
import edu.fiu.Group5Bookstore.model.User;
import edu.fiu.Group5Bookstore.service.BookService;
import edu.fiu.Group5Bookstore.service.CartService;
import edu.fiu.Group5Bookstore.service.RatingService;
import edu.fiu.Group5Bookstore.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rating")

public class RatingController {

    private final BookService bookService;
    private final UserService userService;
    private final CartService cartService;
    private RatingService ratingService;

    public RatingController(RatingService ratingService, UserService userService, BookService bookService, CartService cartService) {
        this.ratingService = ratingService;
        this.userService = userService;
        this.cartService =  cartService;
        this.bookService = bookService;
    }

    @PostMapping("/createRating")
    public ResponseEntity<Integer> createRating(@RequestBody RatingPostDTO ratingPostDTO) {
        User foundUser =  userService.findUser(ratingPostDTO.getUserId());
        Book foundBook = bookService.findBook(ratingPostDTO.getBookId());
        try {
            Rating createRating = ratingService.createRating(foundBook, foundUser, ratingPostDTO.getRating());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}

