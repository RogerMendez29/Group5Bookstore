package edu.fiu.Group5Bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * An entity of this class represents a single user
 * The annotation JsonIgnore was used here to prevent the password from being serialized in the response object
 */

@Entity
@Data
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Username")
    private String username;
    @Column(name = "Password")
    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CartItem> cartItems = new ArrayList<>();

    public User() {
    }

    public User(int id, String username, String password, List<CartItem> cartItems) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
