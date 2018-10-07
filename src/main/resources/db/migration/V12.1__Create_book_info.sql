CREATE TABLE book_info
(
    id serial NOT NULL,
    title character varying(255) NOT NULL,
    author_id integer NOT NULL REFERENCES author(id),
    PRIMARY KEY (id)
)