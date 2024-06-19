package edu.fiu.Group5Bookstore.model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

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
    private LocalDate datestamp; // datestamp

    public Rating() {
    }

    public Rating( User user, Book book, int rating, LocalDate datestamp) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        this.user = user;
        this.book = book;
        this.rating = rating;
        this.datestamp = datestamp;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + user.getId() +
                ", book= " + book.getId() +
                ", rating=" + rating +
                ", datestamp=" + datestamp +
                '}';
    }
}
