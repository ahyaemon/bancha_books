CREATE TABLE sentence
(
    sentence_id serial NOT NULL,
    book_id integer NOT NULL REFERENCES book(book_id),
    sentence character varying(1023) NOT NULL,
    PRIMARY KEY (sentence_id)
)