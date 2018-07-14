CREATE TABLE comment
(
    comment_id serial NOT NULL,
    sentence_id int,
    name character varying(255),
    comment character varying(255),
    PRIMARY KEY (comment_id)
)