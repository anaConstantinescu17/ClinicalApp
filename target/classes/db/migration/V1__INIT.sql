CREATE SCHEMA clinic;
SET search_path = clinic, pg_catalog;


CREATE sequence clinic.hibernate_sequence start WITH 1 increment BY 1;

CREATE TABLE department (
    id int primary key,
    name varchar(50) not null,
    description varchar(250) not null
);

CREATE TABLE doctor (
    id int primary key,
    department_id int not null,
    name varchar(50) not null,
    description varchar(250) not null,
    start_time time without time zone not null,
    end_time time without time zone not null,
    CONSTRAINT fk_department FOREIGN KEY(department_id)
        REFERENCES department(id)
);

