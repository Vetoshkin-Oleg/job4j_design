create table employees(
    id serial primary key,
    name varchar(255),
    position_id int references position(id)
);

insert into employees(name, position_id) values('Boris', 1);
insert into employees(name, position_id) values('Ivan', 1);
insert into employees(name, position_id) values('Kiril', 1);
insert into employees(name, position_id) values ('Marina', 2);
insert into employees(name, position_id) values ('Pers', 3);
insert into employees(name) values ('Alexander');