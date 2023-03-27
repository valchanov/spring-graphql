package com.example.springgraphql.book;

import com.example.springgraphql.author.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getById(Long id) {
        return bookRepository.findById(id);
    }

    public Book create(BookInput bookInput) {
        var author = authorService.getById(bookInput.authorId())
                                  .orElseThrow(() -> new IllegalArgumentException("Author not found"));
        return bookRepository.save(new Book(bookInput.title(), author, bookInput.description()));
    }

    public boolean delete(Long id) {
        bookRepository.deleteById(id);
        return true;
    }
}
