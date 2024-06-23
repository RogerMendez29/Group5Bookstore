package edu.fiu.Group5Bookstore.controller;

import edu.fiu.Group5Bookstore.DTOs.CartItemPostDTO;
import edu.fiu.Group5Bookstore.exceptions.GeneralNotFoundException;
import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.model.CartItem;
import edu.fiu.Group5Bookstore.model.User;
import edu.fiu.Group5Bookstore.service.BookService;
import edu.fiu.Group5Bookstore.service.CartService;
import edu.fiu.Group5Bookstore.service.UserService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    public ResponseEntity<?> getSubTotal(@PathVariable String userID)  {
        try{
            User foundUser = userService.findUser(Integer.parseInt(userID));
            List<CartItem> cartItems = cartService.getCartItemsByUserId(foundUser.getId());
            String responseMsg = "The cart for user '" + foundUser.getUsername() + "' (User ID: " + foundUser.getId() + ") is empty.";
            if (cartItems.size() == 0) return new ResponseEntity<>(responseMsg, HttpStatus.OK);
            double grandTotal = cartService.getGrandTotal(cartItems);
            return new ResponseEntity<>(grandTotal, HttpStatus.OK);

        }catch (GeneralNotFoundException exception){
            System.out.println(Arrays.asList(exception.getStackTrace()));
            return new ResponseEntity<>(exception.getMessage(),exception.getStatus());
        }
    }
    @PostMapping("/addToCart")
    public ResponseEntity<?> createCartItem(@RequestBody CartItemPostDTO cartItemPostDTO) {
        try {
            Book foundBook = bookService.findBook(cartItemPostDTO.getBookId());
            User foundUser = userService.findUser(cartItemPostDTO.getUserId());
            CartItem createdCartItem = cartService.createCartItem(foundBook,foundUser, cartItemPostDTO.getQuantity());
            return new ResponseEntity<CartItem>(createdCartItem, HttpStatus.OK);

        } catch (GeneralNotFoundException exception){
            return new ResponseEntity<>(exception.getMessage(),exception.getStatus());
        }
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUsersCart(@PathVariable int userId) {
        try {
            User foundUser = userService.findUser(userId);
            List<CartItem> cartItems = cartService.getCartItemsByUserId(foundUser.getId());
            String responseMsg = "The cart for user '" + foundUser.getUsername() + "' (User ID: " + foundUser.getId() + ") is empty.";
            if (cartItems.size() == 0) return new ResponseEntity<>(responseMsg, HttpStatus.OK);
            return new ResponseEntity<>(cartItems, HttpStatus.OK);

        } catch (GeneralNotFoundException exception){
            return new ResponseEntity<>(exception.getMessage(),exception.getStatus());
        }
    }

    @DeleteMapping("/delete/user/{userId}/book/{bookId}")
    public ResponseEntity<String> deleteCartItem(@PathVariable int userId,@PathVariable int bookId ) {
        try{
            cartService.deleteCartItem(userId,bookId);
            User foundUser = userService.findUser(userId);
            Book foundBook = bookService.findBook(bookId);
            String responseMsg = "The cart item associated with " +foundUser.toString() +" & Book titled '" + foundBook.getTitle() + "' (Book ID: " + bookId + ") has been successfully deleted.";
            return ResponseEntity.ok(responseMsg);

        } catch (GeneralNotFoundException exception){
            return new ResponseEntity<>(exception.getMessage(),exception.getStatus());
        }
    }
}
