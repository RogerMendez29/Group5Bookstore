package edu.fiu.Group5Bookstore.repository;

import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.model.Comment;
import edu.fiu.Group5Bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByBookId(int bookId);
}
