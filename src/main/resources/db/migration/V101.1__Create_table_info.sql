CREATE TABLE table_info
(
    id SERIAL NOT NULL,
    name TEXT UNIQUE NOT NULL,
    version TEXT NOT NULL,
    PRIMARY KEY (id)
)
