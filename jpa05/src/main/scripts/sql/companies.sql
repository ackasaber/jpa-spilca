CREATE TABLE companies
   (company_id INTEGER,
    company_name VARCHAR(50) NOT NULL,
    CONSTRAINT companies_pk PRIMARY KEY (company_id));

CREATE TABLE addresses
   (company_id INTEGER NOT NULL,
    address_string VARCHAR(255) NOT NULL,
    CONSTRAINT address_pk PRIMARY KEY (company_id),
    CONSTRAINT address_company_pk FOREIGN KEY (company_id)
               REFERENCES companies (company_id));

CREATE TABLE residence_addresses
   (id INTEGER,
    address_string VARCHAR(255) NOT NULL,
    CONSTRAINT residence_address_pk PRIMARY KEY (id),
    CONSTRAINT residence_address_company_fk FOREIGN KEY (id)
               REFERENCES companies (company_id));

CREATE SEQUENCE company_id_sequence
    INCREMENT BY 5
    START WITH 1;
