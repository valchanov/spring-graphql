DROP TABLE IF EXISTS book, author;

CREATE TABLE author
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);

CREATE TABLE book
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(250) NOT NULL,
    author_id   VARCHAR(250) NOT NULL,
    description VARCHAR(500) DEFAULT NULL,
    CONSTRAINT FK_AuthorBook FOREIGN KEY (author_id)
        REFERENCES author (id)
);
