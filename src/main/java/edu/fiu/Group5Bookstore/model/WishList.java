package edu.fiu.Group5Bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wishListID;
    private int userId;
    private String wishlist_name;

    public WishList() {

    }

    public WishList(int wishListID, int userId, String wishlist_name) {
        this.wishListID = wishListID;
        this.userId = userId;
        this.wishlist_name = wishlist_name;
    }

    @Override
    public String toString() {
        return "WishList{" +
                "wishListID = " + wishListID +
                ", user = " + userId +
                '}';
    }
}