package edu.fiu.Group5Bookstore.repository;

import edu.fiu.Group5Bookstore.model.Book;
import edu.fiu.Group5Bookstore.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Book findByid(int userId);
    List<Book> findByGenre(String genre);
    Book findByIsbn(String isbn);
    List<Book> findTop10ByOrderByCopiesSoldDesc();
}



