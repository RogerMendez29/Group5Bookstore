package edu.fiu.Group5Bookstore.controller;
import edu.fiu.Group5Bookstore.DTOs.CartItemPostDTO;
import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.model.CartItem;
import edu.fiu.Group5Bookstore.model.CreditCard;
import edu.fiu.Group5Bookstore.model.User;
import edu.fiu.Group5Bookstore.model.CreditCard;
import edu.fiu.Group5Bookstore.repository.CreditCardRepository;
import edu.fiu.Group5Bookstore.repository.UserRepository;
import edu.fiu.Group5Bookstore.service.BookService;
import edu.fiu.Group5Bookstore.service.CartService;
import edu.fiu.Group5Bookstore.service.CreditCardService;
import edu.fiu.Group5Bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/creditcard")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @PostMapping("/{username}")
    public void createCreditCard(@PathVariable String username, @RequestBody CreditCard creditCard)
    {
        creditCardService.createCreditCard(username, creditCard);
    }

}
