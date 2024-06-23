package edu.fiu.Group5Bookstore.repository;

import edu.fiu.Group5Bookstore.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    List<Rating> findByBookId(int bookId);
}

