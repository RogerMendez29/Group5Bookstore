package edu.fiu.Group5Bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private int rating; // rating
    private Date timestamp; // datestamp

    public Rating() {
    }

    public Rating(User user, Book book, int rating, Date timestamp) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        this.user = user;
        this.book = book;
        this.rating = rating;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + user.getId() +
                ", book= " + book.getId() +
                ", rating=" + rating +
                ", dateStamp=" + timestamp +
                '}';
    }
}
