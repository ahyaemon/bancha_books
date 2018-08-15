CREATE TABLE comment
(
    comment_id serial NOT NULL,
    sentence_id int NOT NULL REFERENCES sentence(sentence_id),
    name character varying(255) NOT NULL,
    comment character varying(255) NOT NULL,
    can_delete boolean NOT NULL,
    delete_key character varying(255),
    PRIMARY KEY (comment_id)
)