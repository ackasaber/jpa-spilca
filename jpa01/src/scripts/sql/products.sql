CREATE TABLE products
   (id SMALLINT,
    name VARCHAR(45) NOT NULL,
    price DECIMAL(5, 2) NOT NULL,
    expiration_date DATE NOT NULL,
    CONSTRAINT products_pk PRIMARY KEY (id));

CREATE TABLE next_id_table
   (entity_name VARCHAR(20),
    next_id SMALLINT NOT NULL,
    CONSTRAINT next_id_table_pk PRIMARY KEY (entity_name));