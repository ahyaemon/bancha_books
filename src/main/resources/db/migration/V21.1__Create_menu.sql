CREATE TABLE menu
(
    id serial NOT NULL,
    title character varying(255) NOT NULL,
    subtitle character varying(255) NOT NULL,
    url character varying(255) NOT NULL,
    PRIMARY KEY (id)
)