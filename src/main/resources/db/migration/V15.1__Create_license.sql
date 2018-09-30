CREATE TABLE license
(
    license_id serial NOT NULL,
    book_id integer NOT NULL REFERENCES book(book_id),
    notice CHARACTER VARYING(1000) NOT NULL,
    license_type CHARACTER VARYING(16) NOT NULL,
    PRIMARY KEY (license_id)
)
