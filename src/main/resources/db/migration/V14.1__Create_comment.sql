CREATE TABLE comment
(
    comment_id serial NOT NULL,
    sentence_id int NOT NULL REFERENCES sentence(sentence_id),
    account_id int NOT NULL REFERENCES account(account_id),
    comment character varying(255) NOT NULL,
    PRIMARY KEY (comment_id)
)