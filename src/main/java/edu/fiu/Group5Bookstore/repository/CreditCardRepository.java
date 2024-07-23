package edu.fiu.Group5Bookstore.repository;

import edu.fiu.Group5Bookstore.model.CartItem;
import edu.fiu.Group5Bookstore.model.CreditCard;
import edu.fiu.Group5Bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository <CreditCard, Integer> {

}
