-- create table usr (
--     id int8 generated by default as identity not null,
--     first_name varchar(255),
--     last_name varchar(255),
--     email varchar(255),
--     password varchar(255),
-- --     user_role_id int8 not null,
--     last_visit timestamp,
--     creat_date timestamp,
--     update_date timestamp,
--     primary key (id)
-- );

create table users (
    id bigserial not null,
    email varchar(255),
    password varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    avatar int8,
    last_visit timestamp,
    created_at timestamp,
    updated_at timestamp,
    primary key (id)
);

alter table if exists users add constraint UK_password unique (password)
