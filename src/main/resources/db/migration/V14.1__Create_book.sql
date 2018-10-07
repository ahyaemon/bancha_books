CREATE TABLE book
(
    id serial NOT NULL,
    book_info_id integer NOT NULL REFERENCES book_info(id),
    PRIMARY KEY (id)
)