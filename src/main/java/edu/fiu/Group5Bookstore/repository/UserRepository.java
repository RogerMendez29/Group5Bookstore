package edu.fiu.Group5Bookstore.repository;

import edu.fiu.Group5Bookstore.model.CartItem;
import edu.fiu.Group5Bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository <User, Integer> {

    User findByid(int userId);



}
