CREATE TABLE subtitle
(
    subtitle_id serial NOT NULL,
    title_cd character varying(255),
    subtitle character varying(255),
    PRIMARY KEY (subtitle_id)
)