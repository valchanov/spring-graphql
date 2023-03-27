package com.example.springgraphql.author;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public Iterable<Author> getAllBooks() {
        return authorRepository.findAll();
    }

    @Cacheable(value = "book",key = "#id")
    public Optional<Author> getById(String id) {
        System.out.println("get()");
        return authorRepository.findById(id);
    }

    @CachePut(value = "book",key = "#result.id")
    public Author create(Author author) {
        System.out.println("create()");
        return authorRepository.save(author);
    }

    @CachePut(value = "book", key = "#id")
    public Author update(String id, Author author) {
        System.out.println("update()");
        return authorRepository.save(author);
    }

    @CacheEvict(value = "book",key = "#id")
    public void delete(String id) {
        System.out.println("delete()");
        authorRepository.deleteById(id);
    }
}
