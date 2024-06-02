package edu.fiu.Group5Bookstore.service;

import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.model.CartItem;
import edu.fiu.Group5Bookstore.model.User;
import edu.fiu.Group5Bookstore.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> getCartItemsByUserId(int userId) {
        List<CartItem> bookList = cartItemRepository.findByUserId(userId);
        return bookList;
    }

    public double getGrandTotal(List<CartItem> list) {
        double subtotal = 0.0;

        for ( CartItem item :list) {
           subtotal += item.getPrice();
        }
        return subtotal;
    }

    public CartItem createCartItem(Book book, User user, int quantity) {
        CartItem newCartItem = new CartItem();
        newCartItem.setBook(book);
        newCartItem.setPrice(book.getPrice());
        newCartItem.setUser(user);
        newCartItem.setQuantity(quantity);

        cartItemRepository.save(newCartItem);

        return newCartItem;
    }

    public void deleteCartItem(User foundUser, Book foundBook) {
    }
}
