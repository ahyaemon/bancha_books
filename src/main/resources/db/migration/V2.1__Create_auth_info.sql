CREATE TABLE auth_info
(
    id SERIAL NOT NULL,
    account_id INTEGER UNIQUE NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL,
    role TEXT NOT NULL,
    PRIMARY KEY (id)
)
