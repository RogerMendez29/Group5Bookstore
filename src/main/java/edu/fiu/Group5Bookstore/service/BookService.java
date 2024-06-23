package edu.fiu.Group5Bookstore.service;

import edu.fiu.Group5Bookstore.exceptions.GeneralNotFoundException;
import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

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

    public List<Book> getTopSoldBooks() {
        return bookRepository.findTop10ByOrderByCopiesSoldDesc();
    }

    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}