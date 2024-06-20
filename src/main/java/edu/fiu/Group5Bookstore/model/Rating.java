package edu.fiu.Group5Bookstore.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Rating {
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

    private int rating; // rating
    private LocalDate datestamp; // datestamp

    public Rating() {
    }

    public Rating(int rating, User user, Book book, LocalDate datestamp) {
        this.rating = rating;
        this.user = user;
        this.book = book;
        this.datestamp = datestamp;
    }

    @JsonIgnore
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "rating=" + rating +
                ", user=" + user.getId() +
                ", book=" + book.getId() +
                ", datestamp=" + datestamp +
                '}';
    }
}
