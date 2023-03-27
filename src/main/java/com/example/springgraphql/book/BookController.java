package com.example.springgraphql.book;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @QueryMapping
    Iterable<Book> books() {
        return bookService.getAllBooks();
    }

//    @GetMapping("/{id}")
//    Optional<Book> getByid(@PathVariable String id) {
//        return bookService.getById(id);
//    }
//
//    @PostMapping
//    Book save(@RequestBody Book book) {
//        return bookService.create(book);
//    }
//
//    @PutMapping("/{id}")
//    Book update(@RequestBody Book book, @PathVariable String id) {
//        return bookService.update(id, book);
//    }
//
//    @DeleteMapping(("/{id}"))
//    void save(@PathVariable String id) {
//        bookService.delete(id);
//    }
}
