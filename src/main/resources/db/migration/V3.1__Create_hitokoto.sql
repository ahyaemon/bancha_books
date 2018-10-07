CREATE TABLE hitokoto
(
    id serial NOT NULL,
    account_id INTEGER UNIQUE NOT NULL REFERENCES account(id),
    value CHARACTER VARYING(1024),
    PRIMARY KEY (id)
)
