CREATE TABLE parts
   (part_id SMALLINT AUTO_INCREMENT,
    part_name VARCHAR(45) NOT NULL,
    part_count SMALLINT NOT NULL,
    CONSTRAINT parts_pk PRIMARY KEY (part_id));
