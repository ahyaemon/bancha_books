CREATE TABLE auth_info
(
    id serial NOT NULL,
    account_id INTEGER UNIQUE NOT NULL REFERENCES account(id),
    email CHARACTER varying(255) UNIQUE NOT NULL,
    password CHARACTER varying(255) NOT NULL,
    role CHARACTER varying(255) NOT NULL,
    PRIMARY KEY (id)
)
