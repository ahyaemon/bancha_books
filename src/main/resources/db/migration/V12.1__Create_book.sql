CREATE TABLE book
(
    id serial NOT NULL,
    name character varying(255) NOT NULL,
    author_id integer NOT NULL REFERENCES author(id),
    PRIMARY KEY (id)
)