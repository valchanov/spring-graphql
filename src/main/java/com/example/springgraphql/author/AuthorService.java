package com.example.springgraphql.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public Iterable<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> getById(Long id) {
        return authorRepository.findById(id);
    }

    public Author create(String name) {
        var a = new Author(name);
        return authorRepository.save(a);
    }

    public boolean delete(Long id) {
        authorRepository.deleteById(id);
        return true;
    }
}
