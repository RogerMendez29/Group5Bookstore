package edu.fiu.Group5Bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * An entity of this class represents a single item inside a user's shopping cart
 * The annotation  JsonIgnoreProperties is used here to prevent circular references in the response object
 */

@Entity
@Data
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnoreProperties({"cartItems"}) // Exclude cartItems field from serialization
    private Book book;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"cartItems"}) // Exclude cartItems field from serialization
    private User user;
    private int quantity;
    private double totalPrice;


    public CartItem() {
    }

    public CartItem(int id, Book book, User user, int quantity, double totalPrice) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", book= " + book.getId() +": " +book.getTitle() +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", user=" + user.getId()+": "+ user +
                '}';
    }
}
