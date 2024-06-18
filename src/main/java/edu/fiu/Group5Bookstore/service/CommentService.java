package edu.fiu.Group5Bookstore.service;

import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.model.Comment;
import edu.fiu.Group5Bookstore.model.User;
import edu.fiu.Group5Bookstore.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment createComment(Book book, User user, String comment, LocalDate datestamp) {
        Comment commentFound = commentRepository.findCommentByUserAndBookAndComment(user, book, comment);
        Comment createdComment = new Comment();

        if (commentFound == null) {
            createdComment.setUser(user);
            createdComment.setBook(book);
            createdComment.setComment(comment);
            createdComment.setDatestamp(datestamp);
            commentRepository.save(createdComment);
            return createdComment;
        } else {
            commentFound.setUser(user);
            commentFound.setBook(book);
            commentFound.setComment(comment);
            commentFound.setDatestamp(datestamp);
            commentRepository.save(commentFound);
            return commentFound;
        }
    }

    public List<Comment> getCommentFromBookId(int bookID) {
            return commentRepository.findByBookId(bookID);
    }
}
