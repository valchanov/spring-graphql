package com.example.springgraphql.book;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @QueryMapping
    Iterable<Book> books() {
        return bookService.getAllBooks();
    }

    @QueryMapping
    Optional<Book> bookById(@Argument Long id) {
        return bookService.getById(id);
    }

    @MutationMapping
    Book createBook(@Argument BookInput book) {
        return bookService.create(book);
    }

    @MutationMapping
    boolean deleteBook(@Argument Long id) {
        return bookService.delete(id);
    }
}
