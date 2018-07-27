CREATE TABLE book
(
    book_id serial NOT NULL,
    name character varying(255),
    author_id integer,
    PRIMARY KEY (book_id)
)