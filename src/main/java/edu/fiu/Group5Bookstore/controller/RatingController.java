package edu.fiu.Group5Bookstore.controller;

import edu.fiu.Group5Bookstore.DTOs.RatingPostDTO;
import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.model.Rating;
import edu.fiu.Group5Bookstore.model.User;
import edu.fiu.Group5Bookstore.repository.BookRepository;
import edu.fiu.Group5Bookstore.repository.UserRepository;
import edu.fiu.Group5Bookstore.service.RatingService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rating")
public class RatingController {

    private final RatingService ratingService;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public RatingController(RatingService ratingService, UserRepository userRepository, BookRepository bookRepository) {
        this.ratingService = ratingService;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody RatingPostDTO ratingPostDTO) {
        User user = userRepository.findById(ratingPostDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + ratingPostDTO.getUserId()));

        Book book = bookRepository.findById(ratingPostDTO.getBookId())
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + ratingPostDTO.getBookId()));

        Rating rating = new Rating(ratingPostDTO.getRating(), user, book, ratingPostDTO.getDatestamp());
        Rating savedRating = ratingService.createRating(rating);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedRating);
    }

    @GetMapping("/averageRating/{bookId}")
    public ResponseEntity<Double> getAverageRatingByBookId(@PathVariable int bookId) {
        Double averageRating = ratingService.getAverageRatingByBookId(bookId);

        if (averageRating != null) {
            return ResponseEntity.ok(averageRating);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}




