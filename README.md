# spring-graphql

## Spring Boot, MVC, H2, GraphQL

May test the API on http://localhost:8080/graphiql?path=/graphql with sample queries and mutations:

```graphql
{
    books {
        id
        title
        author {
            name
            books {
                title
            }
        }
    }
    authors {
        name
        books {
            title
        }
    }
    bookById(id: 1) {
        title
    }
    authors {
        name
    }
}

mutation {
    deleteAuthor(id: 2)
    deleteBook(id: 1)
    createAuthor(name: "John Grisham") {
        name
    }
    createBook(book: {title: "New book", description: "...", authorId: 1}) {
        title
    }
}

```
