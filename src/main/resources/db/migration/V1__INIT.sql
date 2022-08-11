CREATE SCHEMA clinic;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

SET search_path = clinic, pg_catalog;

create sequence clinic.hibernate_sequence start with 1 increment by 1;

create table working_days(
    id int primary key,
    day varchar(20) not null,
    start_time time without time zone not null,
    end_time time without time zone not null,

);

create table doctor(
    id uuid DEFAULT public.uuid_generate_v4 (),
    name varchar(50) not null,
    description varchar(200) not null,
    primary key (id),
    CONSTRAINT fk_working_days FOREIGN KEY(working_days)
        REFERENCES working_days(id)
    CONSTRAINT fk_request FOREIGN KEY(request)
        REFERENCES request(id)

);

create table department(
    name varchar(50) primary key,
    description varchar(50) not null,


)