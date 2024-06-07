package edu.fiu.Group5Bookstore.repository;

import edu.fiu.Group5Bookstore.model.WishItem;
import edu.fiu.Group5Bookstore.model.User;
import edu.fiu.Group5Bookstore.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface WishRepository extends JpaRepository<WishItem, Integer> {
    //WishList findWishListFromId(int id);
    List<WishItem> findByWishListID(int wishListID);
}
