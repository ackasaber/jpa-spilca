CREATE TABLE products
   (id INTEGER,
    name VARCHAR(50) NOT NULL,
    price DECIMAL(9, 2) NOT NULL,
    CONSTRAINT products_pk PRIMARY KEY (id));

INSERT INTO products (id, name, price)
VALUES (1, 'Ale', 5.50),
       (2, 'Beer', 2.00),
       (3, 'Cider', 2.10),
       (4, 'Vodka', 4.30),
       (5, 'Wine', 7.99);