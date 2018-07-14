CREATE TABLE ruby
(
    ruby_id serial NOT NULL,
    sentence_id int,
    kanji character varying(15),
    ruby character varying(15),
    PRIMARY KEY (ruby_id)
)