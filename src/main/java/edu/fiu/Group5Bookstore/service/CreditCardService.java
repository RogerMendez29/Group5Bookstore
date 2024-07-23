package edu.fiu.Group5Bookstore.service;

import edu.fiu.Group5Bookstore.exceptions.GeneralNotFoundException;
import edu.fiu.Group5Bookstore.model.CreditCard;
import edu.fiu.Group5Bookstore.model.User;
import edu.fiu.Group5Bookstore.repository.CreditCardRepository;
import edu.fiu.Group5Bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    public void createCreditCard(String username, CreditCard creditCard)
    {
        User user = userRepository.findByUsername(username);
        creditCard.setUser(user);
        creditCardRepository.save(creditCard);
        user.setCreditCard(creditCard);
        userRepository.save(user);
    }

}
