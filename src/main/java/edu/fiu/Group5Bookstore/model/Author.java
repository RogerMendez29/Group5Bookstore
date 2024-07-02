package edu.fiu.Group5Bookstore.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String bio;

    private String publisher;

    @OneToMany(mappedBy = "bookAuthor", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Book> books;

    public Author() {
    }

    public Author(int id, String firstName, String lastName, String bio, String publisher) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.publisher = publisher;
    }

    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bio='" + bio + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
