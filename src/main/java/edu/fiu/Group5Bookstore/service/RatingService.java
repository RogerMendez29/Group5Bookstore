package edu.fiu.Group5Bookstore.service;

import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.model.Rating;
import edu.fiu.Group5Bookstore.model.User;
import edu.fiu.Group5Bookstore.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating createRating(Rating rating) {
        validateRating(rating.getRating());
        return ratingRepository.save(rating);
    }

    public Double getAverageRatingByBookId(int bookId) {
        List<Rating> ratings = ratingRepository.findByBookId(bookId);

        if (ratings.isEmpty()) {
            return null; // Or handle as appropriate if no ratings are found
        }

        int sum = 0;
        for (Rating rating : ratings) {
            sum += rating.getRating();
        }

        double average = (double) sum / ratings.size();
        return average;
    }

    private void validateRating(int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
    }
}

