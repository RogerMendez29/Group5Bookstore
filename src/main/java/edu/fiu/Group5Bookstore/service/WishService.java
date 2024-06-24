package edu.fiu.Group5Bookstore.service;
import edu.fiu.Group5Bookstore.exceptions.GeneralBadRequestException;
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
    public void verifyBookId(WishItem wi) throws GeneralNotFoundException {
        int bookId = wi.getBook().getId();
        int wishlistId = wi.getWishListID();
        if (!bookRepository.existsById(bookId)) {
            throw new GeneralNotFoundException("No book found with ID " + bookId + ".", HttpStatus.NOT_FOUND);
        }
        if (wishItemRepository.existsByBookIdAndWishListID(bookId, wishlistId)) {
            throw new GeneralBadRequestException("Book with ID " + bookId + " is already in whitelist " + wishlistId + ".", HttpStatus.BAD_REQUEST);
        }
    }

    public List<WishItem> getWishItemsFromId(int wishlistId) {
        verifyWishListId(wishlistId);
        return wishItemRepository.findByWishListID(wishlistId);
    }

    public void createWishlist(WishList wl) {
        if (wishListRepository.existsById(wl.getWishListID())) {
            throw new GeneralBadRequestException("Wish list with ID " + wl.getWishListID() + " already exists.", HttpStatus.BAD_REQUEST);
        }
        if (wishListRepository.existsByWishListName(wl.getWishListName())) {
            throw new GeneralBadRequestException("Wish list with name " + wl.getWishListName() + " already exists.", HttpStatus.BAD_REQUEST);
        }
        wishListRepository.save(wl);
    }

    public void addBook(WishItem wi) {
        verifyWishListId(wi.getWishListID());
        verifyBookId(wi);
        wishItemRepository.save(wi);
    }
    public void removeBook(WishItem wi) {
        verifyWishListId(wi.getWishListID());
        verifyBookId(wi);
        wishItemRepository.delete(wi);
    }

    public int incrementWishlistId(int userId) {
        try {
            int amntWishlists = wishListRepository.findAllByUserId(userId).size();
            if (amntWishlists == 3) {
                throw new GeneralBadRequestException("User with ID " + userId + " has already exceeded 3 wishlists.", HttpStatus.BAD_REQUEST);
            }
            return (int)(wishListRepository.count() + 1);
        } catch (GeneralNotFoundException exception) {
            return 1;
        }
    }
}
