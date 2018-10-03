CREATE TABLE comment
(
    id serial NOT NULL,
    sentence_id int NOT NULL REFERENCES sentence(id),
    account_id int NOT NULL REFERENCES account(id),
    comment character varying(255) NOT NULL,
    PRIMARY KEY (id)
)