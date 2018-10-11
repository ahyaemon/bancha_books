CREATE TABLE comment
(
    id SERIAL NOT NULL,
    sentence_id INTEGER NOT NULL,
    account_id INTEGER NOT NULL,
    value TEXT NOT NULL,
    PRIMARY KEY (id)
)
