package edu.fiu.Group5Bookstore.repository;

import edu.fiu.Group5Bookstore.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {
    List<WishList> findAllByUserId(int userId);
    boolean existsByUserIdAndWishListName(int userId, String wishListName);
}
