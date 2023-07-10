create table position(
    id serial primary key,
    name varchar(255)
);

insert into position(name) values ('programmer');
insert into position(name) values ('project manager');
insert into position(name) values ('director');