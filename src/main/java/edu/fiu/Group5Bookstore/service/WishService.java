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
            throw new GeneralBadRequestException("Wish list with ID " + wl.getWishListID() + " already exists.", HttpStatus.BAD_REQUEST);
        }
        if (wishListRepository.existsByUserIdAndWishListName(wl.getUserId(), wl.getWishListName())) {
            throw new GeneralBadRequestException("Wish list with name " + wl.getWishListName() + " already exists.", HttpStatus.BAD_REQUEST);
        }
        wishListRepository.save(wl);
    }

    public void addBook(WishItem wi) {
        verifyWishListId(wi.getWishListID());
        verifyBookId(wi);

        if (wishItemRepository.findByBookIdAndWishListID(wi.getBook().getId(), wi.getWishListID()) != null) {
            throw new GeneralBadRequestException("Book with ID " + wi.getBook().getId() + " is already in whitelist " + wi.getWishListID() + ".", HttpStatus.BAD_REQUEST);
        }

        wishItemRepository.save(wi);
    }
    public void removeBook(WishItem wi) {
        verifyWishListId(wi.getWishListID());
        verifyBookId(wi);

        WishItem wi2 = wishItemRepository.findByBookIdAndWishListID(wi.getBook().getId(), wi.getWishListID());

        if (wi2 == null) {
            throw new GeneralBadRequestException("Book with ID " + wi.getBook().getId() + " is not in whitelist " + wi.getWishListID() + ".", HttpStatus.BAD_REQUEST);
        }

        wishItemRepository.delete(wi2);
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
