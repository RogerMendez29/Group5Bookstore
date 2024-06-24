package edu.fiu.Group5Bookstore.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wishListID;
    private int userId;
    private String wishListName;

    public WishList() {

    }

    public WishList(int wishListID, int userId, String wishListName) {
        this.wishListID = wishListID;
        this.userId = userId;
        this.wishListName = wishListName;
    }

    @Override
    public String toString() {
        return "WishList{" +
                "wishListID = " + wishListID +
                ", wishListName = " + wishListName +
                ", user = " + userId +
                '}';
    }
}