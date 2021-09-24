CREATE TABLE prices
   (id SMALLINT,
    amount DECIMAL(9, 2) NOT NULL,
    currency SMALLINT NOT NULL,
    offer_type VARCHAR(10) NOT NULL);

CREATE SEQUENCE prices_id_sequence
    INCREMENT BY 5
    START WITH 1;