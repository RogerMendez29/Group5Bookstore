package edu.fiu.Group5Bookstore.service;

import edu.fiu.Group5Bookstore.model.Author;
import edu.fiu.Group5Bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    public Author getAuthorById(int id) {
        return authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author not found"));
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
