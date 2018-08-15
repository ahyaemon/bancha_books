CREATE TABLE book
(
    book_id serial NOT NULL,
    name character varying(255) NOT NULL,
    author_id integer NOT NULL REFERENCES author(author_id),
    PRIMARY KEY (book_id)
)