CREATE TABLE times
   (id SMALLINT,
    date_column DATE,
    time_column TIME,
    date_time TIMESTAMP,
    date_time2 TIMESTAMP,
    zdate_time TIMESTAMP WITH TIME ZONE,
    legacy_date DATE,
    CONSTRAINT times_pk PRIMARY KEY (id));

CREATE SEQUENCE time_id_sequence;