CREATE TABLE departments
   (code VARCHAR(10),
    number INTEGER,
    name VARCHAR(45),
    CONSTRAINT departments_pk PRIMARY KEY (code, number));
