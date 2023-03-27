package com.example.springgraphql.book;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Cacheable(value = "book",key = "#id")
    public Optional<Book> getById(String id) {
        System.out.println("get()");
        return bookRepository.findById(id);
    }

    @CachePut(value = "book",key = "#result.id")
    public Book create(Book book) {
        System.out.println("create()");
        return bookRepository.save(book);
    }

    @CachePut(value = "book", key = "#id")
    public Book update(String id, Book book) {
        System.out.println("update()");
        return bookRepository.save(book);
    }

    @CacheEvict(value = "book",key = "#id")
    public void delete(String id) {
        System.out.println("delete()");
        bookRepository.deleteById(id);
    }
}
