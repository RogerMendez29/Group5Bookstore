package edu.fiu.Group5Bookstore.service;

import edu.fiu.Group5Bookstore.exceptions.GeneralNotFoundException;
import edu.fiu.Group5Bookstore.model.User;
import edu.fiu.Group5Bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findUser(int userId) {
        User foundUser = userRepository.findByid(userId);
        if (foundUser == null) {
            throw new GeneralNotFoundException("User not found with Id: " + userId, HttpStatus.NOT_FOUND);
        }
        return foundUser;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByID(Integer id){
        return userRepository.findByid(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
