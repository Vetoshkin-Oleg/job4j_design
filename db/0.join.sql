create table departments(
    id serial primary key,
    name varchar(255)
);

create table employees(
    id serial primary key,
    name varchar(255),
    departments_id int references departments(id)
);

insert into departments(name) values ('department_1');
insert into departments(name) values ('department_2');
insert into departments(name) values ('department_3');
insert into departments(name) values ('department_4');

insert into employees(name, departments_id) values ('emp_1', 1);
insert into employees(name, departments_id) values ('emp_2', 1);
insert into employees(name, departments_id) values ('emp_3', 1);
insert into employees(name, departments_id) values ('emp_4', 2);
insert into employees(name, departments_id) values ('emp_5', 2);
insert into employees(name, departments_id) values ('emp_6', 3);

select * from departments;
select * from employees;

select * from departments d left join employees e on d.id = e.departments_id;
select * from departments d right join employees e on d.id = e.departments_id;
select * from departments d full join employees e on d.id = e.departments_id;
select * from departments d cross join employees e;

select * from departments d left join employees e on d.id = e.departments_id
where e.departments_id is null;


select d.id, d.name, e.id, e.name, e.departments_id
from departments d left join employees e on d.id = e.departments_id;

select d.id, d.name, e.id, e.name, e.departments_id
from employees e right join departments d on d.id = e.departments_id;


create type gender as enum ('male', 'female');
create table teens(
    id serial primary key,
    name varchar(255),
	status gender
);
insert into teens(name, status) values ('people_1', 'male');
insert into teens(name, status) values ('people_2', 'male');
insert into teens(name, status) values ('people_3', 'male');
insert into teens(name, status) values ('people_4', 'male');
insert into teens(name, status) values ('people_10', 'female');
insert into teens(name, status) values ('people_20', 'female');
insert into teens(name, status) values ('people_30', 'female');
insert into teens(name, status) values ('people_40', 'female');
select * from teens;

select * from teens t1 cross join teens t2
where t1.status != t2.status;