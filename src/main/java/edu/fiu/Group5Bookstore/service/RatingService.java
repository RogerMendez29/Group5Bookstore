package edu.fiu.Group5Bookstore.service;

import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.model.Rating;
import edu.fiu.Group5Bookstore.model.User;
import edu.fiu.Group5Bookstore.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Rating createRating(Book book, User user, int rating, LocalDate datestamp) {
        Rating ratingFound = ratingRepository.findRatingByUserAndBookAndRating(user, book, rating);
        if (ratingFound == null) {
            Rating createdRating = new Rating();
            createdRating.setUser(user);
            createdRating.setBook(book);
            createdRating.setRating(rating);
            createdRating.setDatestamp(datestamp);
            ratingRepository.save(createdRating);
            return createdRating;
        } else {
            ratingFound.setUser(ratingFound.getUser());
            ratingFound.setBook(ratingFound.getBook());
            ratingFound.setRating(ratingFound.getRating());
            ratingFound.setDatestamp(ratingFound.getDatestamp());
            ratingRepository.save(ratingFound);
            return ratingFound;
        }
    }

    public double getAverageRatingFromBookId(int bookId) {
       List<Rating> avgRating = ratingRepository.findByBookId(bookId);
        return avgRating.stream().mapToDouble(Rating::getRating).average().orElse(0.0);
    }

    public List<Rating> getRatingFromBookId(int bookId) {
        return ratingRepository.findByBookId(bookId);
    }
}
