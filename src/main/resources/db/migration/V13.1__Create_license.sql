CREATE TABLE license
(
    id SERIAL NOT NULL,
    book_info_id TEXT NOT NULL,
    notice TEXT NOT NULL,
    license_type TEXT NOT NULL,
    PRIMARY KEY (id)
)
