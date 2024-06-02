package edu.fiu.Group5Bookstore.service;

import edu.fiu.Group5Bookstore.model.User;
import edu.fiu.Group5Bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findUser(int userId) {
        return userRepository.findByid(userId);
    }
}
