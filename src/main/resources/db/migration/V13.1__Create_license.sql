CREATE TABLE license
(
    id serial NOT NULL,
    book_info_id integer NOT NULL REFERENCES book_info(id),
    notice CHARACTER VARYING(1000) NOT NULL,
    license_type CHARACTER VARYING(16) NOT NULL,
    PRIMARY KEY (id)
)
