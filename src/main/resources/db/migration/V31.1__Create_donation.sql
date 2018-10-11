CREATE TABLE donation
(
    id SERIAL NOT NULL,
    name TEXT NOT NULL,
    comment TEXT,
    amount BIGINT NOT NULL,
    PRIMARY KEY (id)
)
