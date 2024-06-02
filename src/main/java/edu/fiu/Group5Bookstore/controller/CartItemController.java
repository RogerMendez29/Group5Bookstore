package edu.fiu.Group5Bookstore.controller;

import edu.fiu.Group5Bookstore.DTOs.CartItemPostDTO;
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

        List<CartItem> cartItems = cartService.getCartItemsByUserId(foundUser.getId());

        System.out.println("Cart items here"+cartItems);
        double grandTotal = cartService.getGrandTotal(cartItems);
        return new ResponseEntity<>(grandTotal, HttpStatus.OK);
    }
    @PostMapping("/addToCart")
    public ResponseEntity<CartItem> createCartItem(@RequestBody CartItemPostDTO cartItemPostDTO) {
        User foundUser = userService.findUser(cartItemPostDTO.getUserId());
        Book foundBook = bookService.findBook(cartItemPostDTO.getBookId());
        CartItem createdCartItem = cartService.createCartItem(foundBook,foundUser, cartItemPostDTO.getQuantity());

         return new ResponseEntity<CartItem>(createdCartItem, HttpStatus.OK);

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CartItem>> getUsersCart(@PathVariable int userId) {
        User foundUser = userService.findUser(userId);
        List<CartItem> cartItems = cartService.getCartItemsByUserId(foundUser.getId());
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

    @DeleteMapping("/delete/user/{userId}/book/{bookId}")
    public ResponseEntity<String> deleteCartItem(@PathVariable int userId,@PathVariable int bookId ) {
        cartService.deleteCartItem(userId,bookId);
        Book foundBook = bookService.findBook(bookId);
        String responseMsg = "Cart item for user " + userId + " and book '" + foundBook.getTitle() + "' (Id: " + bookId + ") was deleted successfully.";
        return ResponseEntity.ok(responseMsg);

    }


}
