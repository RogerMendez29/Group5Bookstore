package edu.fiu.Group5Bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class WishItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private int wishListID;

    public WishItem() {

    }

    public WishItem(Book book, int wishListID) {
        this.book = book;
        this.wishListID = wishListID;
        //wishlistID
    }

    @Override
    public String toString() {
        return "WishItem{" +
                ", book= " + book.getId() +": " +book.getTitle() +
                ", wishListID = " + wishListID +
                '}';
    }
}