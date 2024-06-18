package edu.fiu.Group5Bookstore.model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String comment;
    private LocalDate datestamp;

    public Comment() {
    }

    public Comment(Book book, User user, String comment, LocalDate datestamp) {
        this.book = book;
        this.user = user;
        this.comment = comment;
        this.datestamp = datestamp;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + user.getId() +
                ", book= " + book.getId() +
                ", comment=" + comment +
                ", datestamp=" + datestamp +
                '}';
    }

}
