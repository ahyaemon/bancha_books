CREATE TABLE donation
(
    donation_id serial NOT NULL,
    name character varying(255) NOT NULL,
    comment character varying(255),
    amount bigint NOT NULL,
    PRIMARY KEY (donation_id)
    
)