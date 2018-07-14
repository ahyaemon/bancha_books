CREATE TABLE sentence
(
    sentence_id serial NOT NULL,
    book_id integer,
    sentence character varying(1023),
    PRIMARY KEY (sentence_id)
)