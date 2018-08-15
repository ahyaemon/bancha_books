CREATE TABLE subtitle
(
    subtitle_id serial NOT NULL,
    title_cd character varying(255) NOT NULL,
    subtitle character varying(255) NOT NULL,
    PRIMARY KEY (subtitle_id)
)