create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price)
values ('aaa', 2000), ('bbb', 3000), ('ccc', 4000),
('ddd', 200), ('eee', 300), ('fff', 400),
('ggg', 5000), ('hhh', 8000), ('iii', 10000);

insert into people(name)
values ('ZZZ'), ('YYY'), ('XXX'), ('WWW'), ('VVV');

insert into devices_people(people_id, device_id)
values (1, 1), (1, 2);
insert into devices_people(people_id, device_id)
values (2, 3), (2, 4), (2, 5), (2, 6);
insert into devices_people(people_id, device_id)
values (3, 7);
insert into devices_people(people_id, device_id)
values (4, 7), (4, 4);
insert into devices_people(people_id, device_id)
values (5, 8), (5, 9);

select avg(price)
from devices;

select p.name, avg(d.price)
from devices_people as dp
join people p
on dp.people_id = p.id
join devices d
on dp.device_id = d.id
group by p.name;

select p.name, avg(d.price)
from devices_people as dp
join people p
on dp.people_id = p.id
join devices d
on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000;