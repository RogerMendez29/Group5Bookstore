package edu.fiu.Group5Bookstore.service;

import edu.fiu.Group5Bookstore.exceptions.GeneralNotFoundException;
import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.model.CartItem;
import edu.fiu.Group5Bookstore.model.User;
import edu.fiu.Group5Bookstore.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

/**
 * This service class handles all the logic associated with a cart item entity.
 * To help with some common database methods like inserting & deleting we are using Spring Data JPA
 * Spring Data JPA abstracts away many common database query's & operations, so we don't need to write any SQL for most cases.
 */

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
           subtotal += item.getTotalPrice();
        }
        return subtotal;
    }

    public CartItem createCartItem(Book book, User user, int quantity) {
        CartItem itemFound = cartItemRepository.findCartItemByUserAndBook(user, book);
        CartItem newCartItem = new CartItem();

        if (itemFound == null){
            newCartItem.setBook(book);
            newCartItem.setTotalPrice(book.getPrice() * quantity);
            newCartItem.setUser(user);
            newCartItem.setQuantity(quantity);
            cartItemRepository.save(newCartItem);
            return newCartItem;
        }else {
            itemFound.setQuantity(itemFound.getQuantity() + quantity);
            itemFound.setTotalPrice(itemFound.getQuantity() * book.getPrice());
            cartItemRepository.save(itemFound);
            return itemFound;
        }
    }

    public void deleteCartItem(int userId, int bookId) {
        CartItem cartItem = findCartItemByUserIdAndBookId(userId, bookId);
        if (cartItem == null) throw new GeneralNotFoundException("No cart Item found with User Id: " +userId + " & Book Id: " + bookId, HttpStatus.NOT_FOUND);

        cartItemRepository.deleteById(cartItem.getId());
    }

    private CartItem findCartItemByUserIdAndBookId(int userId, int bookId) {
        List<CartItem> listOfItems = getCartItemsByUserId(userId);
        for (CartItem item : listOfItems) {
            if (item.getBook().getId() == bookId) {
                return item;
            }
        }
        return null;
    }
}
