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
    private User user;
    private String name;

    public WishList() {

    }

    public WishList(int wishListID, User user, String name) {
        this.wishListID = wishListID;
        this.user = user;
        this.name = name;
    }

    @Override
    public String toString() {
        return "WishList{" +
                "wishListID = " + wishListID +
                ", user = " + user.getId() + ": " + user +
                '}';
    }
}