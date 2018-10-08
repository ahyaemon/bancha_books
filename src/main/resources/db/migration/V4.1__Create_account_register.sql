CREATE TABLE account_register
(
    id SERIAL NOT NULL,
    email TEXT UNIQUE NOT NULL,
    url_key TEXT UNIQUE NOT NULL,
    create_date_time TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
)
