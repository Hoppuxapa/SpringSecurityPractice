drop type if exists role cascade ;
create type role as enum ('USER', 'ADMIN','GUEST');


drop table if exists users cascade;
create table users
(
    id         serial primary key,
    email      varchar(255),
    age        int Check (age > 0),
    username   varchar(255),
    password   varchar(255),
    first_name varchar(255),
    last_name  varchar(255),
    user_role  userRole
);

INSERT INTO users (email, age, username, password, first_name, last_name, role)
VALUES ('admin@gmail.com', 20, 'admin', 'admin', 'admin', 'admin', 'ADMIN')