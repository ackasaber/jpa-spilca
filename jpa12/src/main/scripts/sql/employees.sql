CREATE TABLE departments
   (id INTEGER,
    name VARCHAR(20) NOT NULL,
    CONSTRAINT departments_pk PRIMARY KEY (id));

CREATE TABLE employees
   (id INTEGER,
    name VARCHAR(100) NOT NULL,
    department_id INTEGER NOT NULL,
    CONSTRAINT employees_pk PRIMARY KEY (id),
    CONSTRAINT employees_fk FOREIGN KEY (department_id)
               REFERENCES departments (id));

INSERT INTO departments (id, name)
VALUES (1, 'Sales'),
       (2, 'R&D');

INSERT INTO employees (id, name, department_id)
VALUES (1, 'Alex', 2),
       (2, 'Judy', 2),
       (3, 'Bob', 1),
       (4, 'Tamara', 1);