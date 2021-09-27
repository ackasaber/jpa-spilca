CREATE TABLE buildings
   (code VARCHAR(45),
    number INTEGER,
    description VARCHAR(100),
    CONSTRAINT buildings_pk PRIMARY KEY (code, number));