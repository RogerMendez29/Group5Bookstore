package edu.fiu.Group5Bookstore.service;

import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.model.Rating;
import edu.fiu.Group5Bookstore.model.User;
import edu.fiu.Group5Bookstore.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class RatingService {

    private final UserService userService;
    private final BookService bookService;
    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository, UserService userService, BookService bookService) {
        this.ratingRepository = ratingRepository;
        this.userService = userService;
        this.bookService = bookService;
    }


    public Rating createRating(Book book, User user, int rating) {
        Rating ratingFound = ratingRepository.findRatingByUserAndBookAndRating(user.getId(), book.getId(), rating);
        if (ratingFound != null) {
            throw new IllegalArgumentException("User has already rated this book.");
        }
        Rating newRating = new Rating();
        newRating.setUser(user);
        newRating.setBook(book);
        newRating.setRating(rating);
        newRating.setTimestamp(new Timestamp(System.currentTimeMillis()));

        return ratingRepository.save(newRating);
    }

}
