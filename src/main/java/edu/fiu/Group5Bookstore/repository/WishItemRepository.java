package edu.fiu.Group5Bookstore.repository;

import edu.fiu.Group5Bookstore.model.WishItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface WishItemRepository extends JpaRepository<WishItem, Integer> {
    //WishList findWishListFromId(int id);
    List<WishItem> findByWishListID(int wishListID);
    boolean existsByBookIdAndWishListID(int bookId, int wishlistID);
}