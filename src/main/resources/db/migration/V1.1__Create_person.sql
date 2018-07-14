CREATE TABLE person
(
    person_id serial NOT NULL,
    name character varying(255),
    comment character varying(255),
    PRIMARY KEY (person_id)
)