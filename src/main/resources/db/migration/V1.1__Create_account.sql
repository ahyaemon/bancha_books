CREATE TABLE account
(
    account_id serial NOT NULL,
    name CHARACTER varying(255) UNIQUE NOT NULL,
    pass CHARACTER varying(255) NOT NULL,
    role CHARACTER varying(255) NOT NULL,
    nickname CHARACTER VARYING(255) UNIQUE NOT NULL,
    PRIMARY KEY (account_id)
)
