CREATE TABLE account
(
    account_id serial NOT NULL,
    name character varying(255) UNIQUE,
    pass character varying(255),
    role character varying(255),
    PRIMARY KEY (account_id)
)