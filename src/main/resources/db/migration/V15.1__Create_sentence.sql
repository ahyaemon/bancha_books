CREATE TABLE sentence
(
    id serial NOT NULL,
    book_id integer NOT NULL REFERENCES book(id),
    sentence character varying(1023) NOT NULL,
    heading integer NOT NULL,
    PRIMARY KEY (id)
)