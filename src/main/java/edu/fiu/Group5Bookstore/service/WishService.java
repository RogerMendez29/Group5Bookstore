package edu.fiu.Group5Bookstore.service;
import edu.fiu.Group5Bookstore.model.WishList;
import edu.fiu.Group5Bookstore.model.WishItem;
import edu.fiu.Group5Bookstore.repository.WishItemRepository;
import edu.fiu.Group5Bookstore.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishService {

    @Autowired
    private WishItemRepository wishItemRepository;

    @Autowired
    private WishListRepository wishListRepository;

    public List<WishItem> getWishItemsFromId(int wishlistId) {
        return wishItemRepository.findByWishListID(wishlistId);
    }
    public void createWishlist(WishList wl) { wishListRepository.save(wl); }

    public void addBook(WishItem wi) { wishItemRepository.save(wi); }
    public void removeBook(WishItem wi) { wishItemRepository.delete(wi); }

    public int incrementWishlistId(int userId) { // better implementation would involve adding a member to the User class, but this is less invasive
        List<WishItem> wl = getWishItemsFromId(userId);
        int max = 0;
        for (WishItem wi : wl) {
            if (wi.getWishListID() > max)
                max = wi.getWishListID();
        }
        return max + 1;
    }
}
