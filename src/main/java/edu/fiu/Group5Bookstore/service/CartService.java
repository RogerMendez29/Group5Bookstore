package edu.fiu.Group5Bookstore.service;

import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.model.CartItem;
import edu.fiu.Group5Bookstore.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    public List<CartItem> getCartItemsByUserId(User userId) {
        return null;
    }

    public double getTotalSubtotal(User foundUser) {
        double subtotal = 0.0;
        return subtotal;
    }

    public CartItem createCartItem(Book bookID, User userID) {
        return null;
    }

    public void deleteCartItem(User foundUser, Book foundBook) {
    }
}
