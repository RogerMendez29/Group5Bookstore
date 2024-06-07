package edu.fiu.Group5Bookstore.repository;

import edu.fiu.Group5Bookstore.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    List<Rating> findByUserId(Integer user_id);

    Rating findRatingByUserAndBookAndRating(User user, Book book, Integer rating);
}


