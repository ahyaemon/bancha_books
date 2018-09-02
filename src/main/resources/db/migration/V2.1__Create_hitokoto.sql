CREATE TABLE hitokoto
(
    hitokoto_id serial NOT NULL,
    account_id INTEGER UNIQUE NOT NULL,
    value CHARACTER VARYING(1024),
    PRIMARY KEY (hitokoto_id)
)
