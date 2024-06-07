package edu.fiu.Group5Bookstore.service;

import edu.fiu.Group5Bookstore.model.WishList;
import edu.fiu.Group5Bookstore.model.WishItem;
import edu.fiu.Group5Bookstore.repository.CartItemRepository;
import edu.fiu.Group5Bookstore.repository.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishService {

    @Autowired
    private WishRepository wishRepository;

    public List<WishItem> getWishItemsFromId(int wishlistId) {
        return wishRepository.findByWishListID(wishlistId);
    }
}
