package edu.fiu.Group5Bookstore.controller;

import edu.fiu.Group5Bookstore.DTOs.WishPostDTO;
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

    @PostMapping("/create")
    public ResponseEntity<Void> createWishlist(@RequestBody WishPostDTO WishPostDTO) {
        int userId = WishPostDTO.getUserId();
        String name = WishPostDTO.getName();

        User foundUser = userService.findUser(userId);


        WishList wl = new WishList(wishService.incrementWishlistId(userId), userId, name);
        wishService.createWishlist(wl);

        return ResponseEntity.status(201).build();
    }

    @PostMapping("/addBook")
    public ResponseEntity<Void> addBook(@RequestBody WishPostDTO WishPostDTO) {
        int bookId = WishPostDTO.getBookId();
        int wishlistId = WishPostDTO.getWishlistId();

        WishItem wi = new WishItem(bookId, wishlistId);
        wishService.addBook(wi);

        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/removeBook")
    public ResponseEntity<Void> removeBook(@RequestBody WishPostDTO WishPostDTO) {
        int bookId = WishPostDTO.getBookId();
        int wishlistId = WishPostDTO.getWishlistId();

        WishItem wi = new WishItem(bookId, wishlistId);
        wishService.removeBook(wi);

        return ResponseEntity.status(200).build();
    }

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
