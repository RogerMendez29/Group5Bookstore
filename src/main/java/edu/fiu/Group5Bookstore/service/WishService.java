package edu.fiu.Group5Bookstore.service;
import edu.fiu.Group5Bookstore.exceptions.GeneralNotFoundException;
import edu.fiu.Group5Bookstore.model.WishList;
import edu.fiu.Group5Bookstore.model.WishItem;
import edu.fiu.Group5Bookstore.repository.BookRepository;
import edu.fiu.Group5Bookstore.repository.WishItemRepository;
import edu.fiu.Group5Bookstore.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishService {

    @Autowired
    private WishItemRepository wishItemRepository;

    @Autowired
    private WishListRepository wishListRepository;

    @Autowired
    private BookRepository bookRepository;

    public void verifyWishListId(int wishListId) throws GeneralNotFoundException {
        if (!wishListRepository.existsById(wishListId)) {
            throw new GeneralNotFoundException("No wish list found with ID " + wishListId + ".", HttpStatus.NOT_FOUND);
        }
    }
    public void verifyBookId(int bookId) throws GeneralNotFoundException {
        if (!bookRepository.existsById(bookId)) {
            throw new GeneralNotFoundException("No book found with ID " + bookId + ".", HttpStatus.NOT_FOUND);
        }
    }

    public List<WishItem> getWishItemsFromId(int wishlistId) {
        verifyWishListId(wishlistId);
        return wishItemRepository.findByWishListID(wishlistId);
    }

    public void createWishlist(WishList wl) {
        if (wishListRepository.existsById(wl.getWishListID())) {
            throw new GeneralNotFoundException("Wish list with ID " + wl.getWishListID() + " already exists.", HttpStatus.NOT_FOUND);
        }
        wishListRepository.save(wl);
    }

    public void addBook(WishItem wi) {
        verifyWishListId(wi.getWishListID());
        verifyBookId(wi.getBookId());
        wishItemRepository.save(wi);
    }
    public void removeBook(WishItem wi) {
        verifyWishListId(wi.getWishListID());
        verifyBookId(wi.getBookId());
        wishItemRepository.delete(wi);
    }

    public int incrementWishlistId(int userId) { // better implementation would involve adding a member to the User class, but this is less invasive
        try {
            List<WishItem> wl = getWishItemsFromId(userId);
            int max = 0;
            for (WishItem wi : wl) {
                if (wi.getWishListID() > max)
                    max = wi.getWishListID();
            }
            return max + 1;
        } catch (GeneralNotFoundException exception) {
            return 1;
        }
    }
}
