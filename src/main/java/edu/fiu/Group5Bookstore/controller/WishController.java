package edu.fiu.Group5Bookstore.controller;

import edu.fiu.Group5Bookstore.DTOs.CartItemPostDTO;
import edu.fiu.Group5Bookstore.model.*;
import edu.fiu.Group5Bookstore.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/wl")
public class WishController {
    private final WishService wishService;
    private final BookService bookService;
    private final UserService userService;

    public WishController(WishService wishService, BookService bookService, UserService userService) {
        this.wishService = wishService;
        this.bookService = bookService;
        this.userService = userService;
    }

    /*@PostMapping("/create")
    public ResponseEntity<String> createWishlist(@PathVariable String name, @PathVariable int userId) {
        User foundUser = userService.findUser(userId);
        WishList wl = wishService.createWishlist(name, userId);

        String responseMsg = "h";
        return ResponseEntity.ok(responseMsg);
    }*/

    @GetMapping("/get/{wishListID}")
    public ResponseEntity<List<Book>> getWishlist(@PathVariable int wishListID) {
        List<WishItem> wishItems = wishService.getWishItemsFromId(wishListID);
        ArrayList<Book> books = new ArrayList<Book>();
        for (WishItem w : wishItems) {
            books.add(bookService.findBook(w.getBookId()));
        }

        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}