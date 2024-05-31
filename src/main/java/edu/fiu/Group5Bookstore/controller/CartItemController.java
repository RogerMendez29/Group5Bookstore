package edu.fiu.Group5Bookstore.controller;

import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.model.CartItem;
import edu.fiu.Group5Bookstore.model.User;
import edu.fiu.Group5Bookstore.service.BookService;
import edu.fiu.Group5Bookstore.service.CartService;
import edu.fiu.Group5Bookstore.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartItemController {

    private final CartService cartService;
    private final BookService bookService;
    private final UserService userService;

    public CartItemController(CartService cartService, BookService bookService, UserService userService) {
        this.cartService = cartService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping("/subtotal/{userID}")
    public ResponseEntity<Double> getSubTotal(@PathVariable String userID) {
        User foundUser = userService.findUser(Integer.parseInt(userID));

        System.out.println(foundUser.getId());
        List<CartItem> cartItems = cartService.getCartItemsByUserId(foundUser.getId());

        System.out.println("Cart items here"+cartItems);
        double grandTotal = cartService.getGrandTotal(cartItems);
        return new ResponseEntity<>(grandTotal, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CartItem> createCartItem(@RequestBody int bookID, int userID) {
        User foundUser = userService.findUser(userID);
        Book foundBook = BookService.findBook(bookID);
        CartItem createdCartItem = cartService.createCartItem(foundBook,foundUser);
        return new ResponseEntity<>(createdCartItem, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CartItem>> getUsersCart(@PathVariable int userID) {
        User foundUser = userService.findUser(userID);
        List<CartItem> cartItems = cartService.getCartItemsByUserId(foundUser.getId());
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

    @DeleteMapping("delete/{userID}/{bookID}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable int userID,@PathVariable int bookID ) {
        User foundUser = userService.findUser(userID);
        Book foundBook = BookService.findBook(bookID);
        cartService.deleteCartItem(foundUser,foundBook);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





}
