CREATE table departments(
    id serial primary key,
    name varchar(255)
);

CREATE table employees(
    id serial primary key,
    name varchar(255),
    departments_id int references departments(id)
);

INSERT INTO departments(name) VALUES ('department_1');
INSERT INTO departments(name) VALUES ('department_2');
INSERT INTO departments(name) VALUES ('department_3');
INSERT INTO departments(name) VALUES ('department_4');

INSERT INTO employees(name, departments_id) VALUES ('emp_1', 1);
INSERT INTO employees(name, departments_id) VALUES ('emp_2', 1);
INSERT INTO employees(name, departments_id) VALUES ('emp_3', 1);
INSERT INTO employees(name, departments_id) VALUES ('emp_4', 2);
INSERT INTO employees(name, departments_id) VALUES ('emp_5', 2);
INSERT INTO employees(name, departments_id) VALUES ('emp_6', 3);

SELECT * FROM departments;
SELECT * FROM employees;

SELECT * FROM departments d LEFT JOIN employees e ON d.id = e.departments_id;
SELECT * FROM departments d RIGHT JOIN employees e ON d.id = e.departments_id;
SELECT * FROM departments d FULL JOIN employees e ON d.id = e.departments_id;
SELECT * FROM departments d CROSS JOIN employees e;

SELECT * FROM departments d LEFT JOIN employees e ON d.id = e.departments_id
WHERE e.departments_id IS NULL;


SELECT d.id, d.name, e.id, e.name, e.departments_id
FROM departments d LEFT JOIN employees e ON d.id = e.departments_id;

SELECT d.id, d.name, e.id, e.name, e.departments_id
FROM employees e RIGHT JOIN departments d ON d.id = e.departments_id;


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
where t1.status != t2.status
and t1.status = 'male';