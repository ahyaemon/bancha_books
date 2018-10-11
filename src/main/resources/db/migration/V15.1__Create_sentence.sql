CREATE TABLE sentence
(
    id SERIAL NOT NULL,
    book_id INTEGER NOT NULL,
    value TEXT NOT NULL,
    heading INTEGER NOT NULL,
    PRIMARY KEY (id)
)
