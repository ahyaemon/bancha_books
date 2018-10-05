CREATE TABLE account
(
    id serial NOT NULL,
    name CHARACTER VARYING(100) UNIQUE NOT NULL,
    PRIMARY KEY (id)
)
