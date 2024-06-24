package edu.fiu.Group5Bookstore.controller;

import edu.fiu.Group5Bookstore.DTOs.WishPostDTO;
import edu.fiu.Group5Bookstore.exceptions.*;
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
    public ResponseEntity<?> createWishlist(@RequestBody WishPostDTO WishPostDTO) {
        try {
            int userId = WishPostDTO.getUserId();
            String name = WishPostDTO.getName();

            User foundUser = userService.findUser(userId);


            WishList wl = new WishList(wishService.incrementWishlistId(userId), userId, name);
            wishService.createWishlist(wl);

            return ResponseEntity.status(201).build();
        } catch (GeneralNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(),exception.getStatus());
        } catch (GeneralBadRequestException exception) {
            return new ResponseEntity<>(exception.getMessage(),exception.getStatus());
        }
    }

    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody WishPostDTO WishPostDTO) {
        try {
            int bookId = WishPostDTO.getBookId();
            int wishlistId = WishPostDTO.getWishlistId();

            WishItem wi = new WishItem(bookService.findBook(WishPostDTO.getBookId()), wishlistId);
            wishService.addBook(wi);

            return ResponseEntity.status(201).build();
        } catch (GeneralNotFoundException exception){
            return new ResponseEntity<>(exception.getMessage(),exception.getStatus());
        } catch (GeneralBadRequestException exception) {
            return new ResponseEntity<>(exception.getMessage(),exception.getStatus());
        }
    }

    @DeleteMapping("/removeBook")
    public ResponseEntity<?> removeBook(@RequestBody WishPostDTO WishPostDTO) {
        try {
            int bookId = WishPostDTO.getBookId();
            int wishlistId = WishPostDTO.getWishlistId();

            WishItem wi = new WishItem(bookService.findBook(WishPostDTO.getBookId()), wishlistId);
            wishService.removeBook(wi);

            return ResponseEntity.status(200).build();
        } catch (GeneralNotFoundException exception){
            return new ResponseEntity<>(exception.getMessage(),exception.getStatus());
        } catch (GeneralBadRequestException exception) {
            return new ResponseEntity<>(exception.getMessage(),exception.getStatus());
        }
    }

    @GetMapping("/get/{wishListID}")
    public ResponseEntity<?> getWishlist(@PathVariable int wishListID) {
        try {
            List<WishItem> wishItems = wishService.getWishItemsFromId(wishListID);
            ArrayList<Book> books = new ArrayList<Book>();
            for (WishItem w : wishItems) {
                books.add(w.getBook());
            }

            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (GeneralNotFoundException exception){
            return new ResponseEntity<>(exception.getMessage(),exception.getStatus());
        }
    }
}
