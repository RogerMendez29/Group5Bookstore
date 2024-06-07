package edu.fiu.Group5Bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
public class WishItem {

    @Id
    private int bookId;

    private int wishListID;

    public WishItem() {

    }

    public WishItem(int bookId, int wishListID) {
        this.bookId = bookId;
        this.wishListID = wishListID;
        //wishlistID
    }

    @Override
    public String toString() {
        return "WishItem{" +
                "book= " + bookId +
                ", wishListID = " + wishListID +
                '}';
    }
}