CREATE TABLE menu
(
    menu_id serial NOT NULL,
    title character varying(255) NOT NULL,
    subtitle character varying(255) NOT NULL,
    url character varying(255) NOT NULL,
    PRIMARY KEY (menu_id)
)