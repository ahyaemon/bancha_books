CREATE TABLE account_register
(
    account_register_id serial NOT NULL,
    email CHARACTER VARYING(255) UNIQUE NOT NULL,
    url_key CHARACTER VARYING(255) UNIQUE NOT NULL,
    create_date_time TIMESTAMP,
    PRIMARY KEY (account_register_id)
)
