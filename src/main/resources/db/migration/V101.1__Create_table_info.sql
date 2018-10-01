CREATE TABLE table_info
(
    table_info_id serial NOT NULL,
    name CHARACTER VARYING(200),
    version character varying(10) NOT NULL,
    PRIMARY KEY (table_info_id)
)