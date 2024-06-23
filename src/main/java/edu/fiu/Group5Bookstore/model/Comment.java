package edu.fiu.Group5Bookstore.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore // Ignore id during serialization
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnoreProperties({"title", "author", "genre", "isbn", "description", "publisher", "yearPublished", "copiesSold", "price"}) // Ignore fields in Book entity
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"username", "cartItems"}) // Ignore fields in User entity
    private User user;

    //@JsonProperty("comment")
    private String comment;

    //@JsonProperty("datestamp")
    private LocalDate datestamp;

    public Comment() {
    }

    public Comment(Book book, User user, String comment, LocalDate datestamp) {
        this.book = book;
        this.user = user;
        this.comment = comment;
        this.datestamp = datestamp;
    }

    @JsonIgnore
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "user=" + user.getId() +
                ", book= " + book.getId() +
                ", comment=" + comment +
                ", datestamp=" + datestamp +
                '}';
    }

}
