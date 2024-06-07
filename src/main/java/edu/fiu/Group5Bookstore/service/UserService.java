package edu.fiu.Group5Bookstore.service;

import edu.fiu.Group5Bookstore.model.User;
import edu.fiu.Group5Bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findUser(int userId) {
        return userRepository.findByid(userId);
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
