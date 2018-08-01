CREATE TABLE donation
(
    donation_id serial NOT NULL,
    name character varying(255),
    comment character varying(255),
    amount bigint,
    PRIMARY KEY (donation_id)
    
)