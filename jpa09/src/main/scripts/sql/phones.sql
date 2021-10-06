CREATE TABLE persons
   (id INTEGER GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR(100) NOT NULL,
    CONSTRAINT persons_pk PRIMARY KEY (id));

CREATE TABLE phones
   (person_id INTEGER,
    phone_type VARCHAR(20),
    number VARCHAR(20) NOT NULL,
    CONSTRAINT phones_pk PRIMARY KEY (person_id, phone_type),
    CONSTRAINT phones_fk FOREIGN KEY (person_id)
               REFERENCES persons (id));

CREATE TABLE phones2
   (person_id INTEGER,
    phone_type VARCHAR(20),
    number VARCHAR(20) NOT NULL,
    CONSTRAINT phones2_pk PRIMARY KEY (person_id, phone_type),
    CONSTRAINT phones2_fk FOREIGN KEY (person_id)
               REFERENCES persons (id));