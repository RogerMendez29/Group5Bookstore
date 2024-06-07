package edu.fiu.Group5Bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private String genre;
    private String isbn;
    private String description;
    private String publisher;

    private int yearPublished;
    private int copiesSold;

    private double price;

    public Book() {
    }

    public Book(int id, String title, String author, String isbn, String genre, String description, double price, String publisher, int yearPublished, int copiesSold) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.description = description;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", isbn='" + isbn + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", publisher='" + publisher + '\'' +
                ", yearPublished=" + yearPublished +'\'' +
                ", copiesSold=" + copiesSold + '\'' +
                '}';
    }
}
