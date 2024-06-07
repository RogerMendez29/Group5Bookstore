package edu.fiu.Group5Bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
public class WishItem {
    private Book book;

    private int wishListID;

    public WishItem() {

    }

    public WishItem(Book book, int wishListID) {
        this.book = book;
        this.wishListID = wishListID;
    }

    @Override
    public String toString() {
        return "WishItem{" +
                "book= " + book.getId() +": " +book.getTitle() +
                ", wishListID = " + wishListID +
                '}';
    }
}