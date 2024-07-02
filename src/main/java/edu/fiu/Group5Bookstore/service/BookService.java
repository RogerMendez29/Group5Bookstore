package edu.fiu.Group5Bookstore.service;

import edu.fiu.Group5Bookstore.exceptions.GeneralNotFoundException;
import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    RatingService ratingService;

    public Book findBook(int bookId) {
        Book foundBook= bookRepository.findByid(bookId);
        if (foundBook == null) {
            throw new GeneralNotFoundException("Book not found with Id: " + bookId, HttpStatus.NOT_FOUND);
        }
        return foundBook;
    }

    public void createBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getBookByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    public List<Book> getBookByPublisher(String publisher) {return bookRepository.findByPublisher(publisher); }

    public List<Book> getTopSoldBooks() {
        return bookRepository.findTop10ByOrderByCopiesSoldDesc();
    }

    public List<Book> getBookByRating(Double rating)
    {
        List<Book> allBooks = getAllBooks();
        List<Book> sufficientRating = new ArrayList<>();
        for(Book b : allBooks)
        {
            double r = ratingService.getAverageRatingByBookId(b.getId());
            if(r>=rating)
                sufficientRating.add(b);
        }
        return sufficientRating;
    }

    public void applyDiscount(String publisher, double discount)
    {
        List<Book> booksByPublisher = bookRepository.findByPublisher(publisher);
        for (Book b : booksByPublisher) {
            double newPrice = b.getPrice() - b.getPrice() * discount;
            newPrice = (double) Math.round(newPrice * 100) / 100;
            b.setPrice(newPrice);
            bookRepository.save(b);
        }
    }

    public List<Book> getBooksByAuthor(int authorId) {
        return bookRepository.findByBookAuthor_Id(authorId);
    }

    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}