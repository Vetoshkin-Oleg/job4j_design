create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna (name, avg_age, discovery_date)
values ('fish', 40, '1949-12-31');
insert into fauna (name, avg_age, discovery_date)
values ('pterodactyl', 10000, '1951-01-01');
insert into fauna (name, avg_age, discovery_date)
values ('griffin', 21000, '1980-01-01');
insert into fauna (name, avg_age, discovery_date)
values ('centaur', 800, '2000-12-01');
insert into fauna (name, avg_age, discovery_date)
values ('phoenix', 5800, null);

select * from fauna
where name like '%fish%';

select * from fauna
where avg_age >= 10000 and avg_age <= 21000;

select * from fauna
where discovery_date is null;

select * from fauna
where discovery_date < '1950-01-01';