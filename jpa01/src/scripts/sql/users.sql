CREATE TABLE users
   (id SMALLINT,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    active BOOLEAN NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (id));

CREATE SEQUENCE user_id_sequence
    INCREMENT BY 5
    START WITH 3;
