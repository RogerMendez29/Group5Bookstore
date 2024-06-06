package edu.fiu.Group5Bookstore.repository;

import edu.fiu.Group5Bookstore.model.CartItem;
import edu.fiu.Group5Bookstore.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    List<CartItem> findByUserId(Integer userId);

    Rating findRatingByUserAndBookAndRating(Integer userId, Integer bookId, Integer rating);
}


