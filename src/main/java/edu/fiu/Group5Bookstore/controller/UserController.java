package edu.fiu.Group5Bookstore.controller;

import edu.fiu.Group5Bookstore.DTOs.CartItemPostDTO;
import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.model.CartItem;
import edu.fiu.Group5Bookstore.model.User;
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

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.saveUser(user);
        //return new ResponseEntity<User>(newUser, HttpStatus.OK);
        return ResponseEntity.ok(newUser);
    }

    /*
    @GetMapping("/getUser")
    public ResponseEntity<User> getUser(@RequestBody String username) {
        User user = new User();
        return ResponseEntity.ok(user);
    }
    */


    @GetMapping("/getUser/username/{username}")
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

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUserID(@PathVariable Integer id) {
        User user = userService.getUserByID(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getUsers")
    public List<User> getUsers(@RequestBody String username) {
        return userService.getAllUsers();
    }

}
