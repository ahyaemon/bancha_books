CREATE TABLE hitokoto
(
    id SERIAL NOT NULL,
    account_id INTEGER UNIQUE NOT NULL,
    value TEXT,
    PRIMARY KEY (id)
)
