package com.example.springgraphql.author;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @QueryMapping
    Iterable<Author> authors() {
        return authorService.getAllAuthors();
    }

    @QueryMapping
    Optional<Author> authorById(@Argument Long id) {
        return authorService.getById(id);
    }

    @MutationMapping
    Author createAuthor(@Argument String name) {
        return authorService.create(name);
    }

    //
//    @PutMapping("/{id}")
//    Book update(@RequestBody Book book, @PathVariable String id) {
//        return authorService.update(id, book);
//    }
//
    @MutationMapping
    boolean deleteAuthor(@Argument Long id) {
       return authorService.delete(id);
    }
}
