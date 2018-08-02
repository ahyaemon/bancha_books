CREATE TABLE menu
(
    menu_id serial NOT NULL,
    title character varying(255),
    subtitle character varying(255),
    url character varying(255),
    PRIMARY KEY (menu_id)
)