package edu.fiu.Group5Bookstore.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public CartItem() {
    }

    public CartItem(int id, Book book, int quantity, double price, User user) {
        this.id = id;
        this.book = book;
        this.quantity = quantity;
        this.price = price;
        this.user = user;
    }


}
