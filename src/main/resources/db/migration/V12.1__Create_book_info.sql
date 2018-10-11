CREATE TABLE book_info
(
    id SERIAL NOT NULL,
    title TEXT NOT NULL,
    author_id INTEGER NOT NULL,
    PRIMARY KEY (id)
)
