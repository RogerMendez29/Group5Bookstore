package edu.fiu.Group5Bookstore.controller;

import edu.fiu.Group5Bookstore.DTOs.CartItemPostDTO;
import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.model.CartItem;
import edu.fiu.Group5Bookstore.model.CreditCard;
import edu.fiu.Group5Bookstore.model.User;
import edu.fiu.Group5Bookstore.repository.UserRepository;
import edu.fiu.Group5Bookstore.service.BookService;
import edu.fiu.Group5Bookstore.service.CartService;
import edu.fiu.Group5Bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService,
                          UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/createUser")
    public void createUser(@RequestBody User user) {
        User newUser = userService.saveUser(user);
    }

    @GetMapping("/getUser/{username}")
    public ResponseEntity<User> getUserUsername(@PathVariable String username) {
        List<User> users = userService.getAllUsers();
        User user = new User();
        for(User u : users) {
            if(u.getUsername().equals(username)){
                user = userService.getUserByID(u.getId());
            }
        }
        return ResponseEntity.ok(user);
    }

    @PutMapping("/updateUser/{username}")
    public void updateUser(@PathVariable String username, @RequestBody User user) {
        userService.updateUser(username, user);
    }

}
