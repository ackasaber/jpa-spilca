CREATE TABLE employees
   (id INTEGER,
    name VARCHAR(100) NOT NULL,
    CONSTRAINT employees_pk PRIMARY KEY (id));

CREATE TABLE managers
   (id INTEGER,
    name VARCHAR(100) NOT NULL,
    responsibility VARCHAR(100) NOT NULL,
    CONSTRAINT managers_pk PRIMARY KEY (id));

CREATE SEQUENCE employee_id_sequence
       INCREMENT BY 5;