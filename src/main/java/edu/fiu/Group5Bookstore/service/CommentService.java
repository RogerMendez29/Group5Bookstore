package edu.fiu.Group5Bookstore.service;

import edu.fiu.Group5Bookstore.model.Comment;
import edu.fiu.Group5Bookstore.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentByBookId(int bookId) {
            return commentRepository.findByBookId(bookId);
    }
}
