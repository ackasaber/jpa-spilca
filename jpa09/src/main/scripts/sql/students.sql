CREATE TABLE students
   (id INTEGER GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR(100) NOT NULL,
    CONSTRAINT students_pk PRIMARY KEY (id));

CREATE TABLE professors
   (id INTEGER GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR(100) NOT NULL,
    CONSTRAINT professors_pk PRIMARY KEY (id));

CREATE TABLE enrollment
   (student_id INTEGER,
    course VARCHAR(100),
    professor_id INTEGER NOT NULL,
    CONSTRAINT enrollment_pk PRIMARY KEY (student_id, course),
    CONSTRAINT enrollment_professor_fk FOREIGN KEY (professor_id)
               REFERENCES professors (id),
    CONSTRAINT enrollment_student_fk FOREIGN KEY (student_id)
               REFERENCES students (id));