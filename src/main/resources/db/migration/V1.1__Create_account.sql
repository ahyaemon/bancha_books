CREATE TABLE account
(
    account_id serial NOT NULL,
    name character varying(255) UNIQUE NOT NULL,
    pass character varying(255) NOT NULL,
    role character varying(255) NOT NULL,
    PRIMARY KEY (account_id)
)