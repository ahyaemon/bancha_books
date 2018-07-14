CREATE TABLE book
(
    book_id serial NOT NULL,
    name character varying(255),
    author character varying(255),
    isbn character varying(255),
    PRIMARY KEY (book_id)
)