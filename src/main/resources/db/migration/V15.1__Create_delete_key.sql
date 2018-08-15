CREATE TABLE delete_key
(
    delete_key_id serial NOT NULL,
    comment_id int NOT NULL REFERENCES comment(comment_id),
    delete_key character varying(255),
    PRIMARY KEY (delete_key_id)
)