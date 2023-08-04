/*Чтение неподтвержденных данных, грязное чтение (read uncommitted, dirty read)*/
CREATE table students(
    id            serial primary key,
    name          text,
    course        int,
    budget        bool,
    speciality    text,
    enroll_date   timestamp
);
INSERT INTO students(name, course, budget, speciality, enroll_date)
VALUES ('AB', 1, true, 'S1', '2020-09-01');
INSERT INTO students(name, course, budget, speciality, enroll_date)
VALUES ('AC', 2, true, 'S1', '2019-09-02');
INSERT INTO students(name, course, budget, speciality, enroll_date)
VALUES ('AD', 3, true, 'M1', '2018-09-03');

set session transaction isolation level read uncommitted;
SELECT * FROM students;
DROP TABLE students CASCADE;


/*Чтение подтвержденных данных (read committed)*/
CREATE table students(
    id            serial primary key,
    name          text,
    course        int,
    budget        bool,
    speciality    text,
    enroll_date   timestamp
);
INSERT INTO students(name, course, budget, speciality, enroll_date)
VALUES ('AB', 1, true, 'S1', '2020-09-01');
INSERT INTO students(name, course, budget, speciality, enroll_date)
VALUES ('AC', 2, true, 'S1', '2019-09-02');
INSERT INTO students(name, course, budget, speciality, enroll_date)
VALUES ('AD', 3, true, 'M1', '2018-09-03');

SELECT * FROM students;
DROP TABLE students CASCADE;


/*Повторяющееся чтение (repeatable read)*/
CREATE table students(
    id            serial primary key,
    name          text,
    course        int,
    budget        bool,
    speciality    text,
    enroll_date   timestamp
);
INSERT INTO students(name, course, budget, speciality, enroll_date)
VALUES ('AB', 1, true, 'S1', '2020-09-01');
INSERT INTO students(name, course, budget, speciality, enroll_date)
VALUES ('AC', 2, true, 'S1', '2019-09-02');
INSERT INTO students(name, course, budget, speciality, enroll_date)
VALUES ('AD', 3, true, 'M1', '2018-09-03');

begin transaction isolation level repeatable read;
select * from students;
drop table students cascade;


/*Сериализация (serializable)*/
create table students(
    id            serial primary key,
    name          text,
    course        int,
    budget        bool,
    speciality    text,
    enroll_date   timestamp
);
INSERT INTO students(name, course, budget, speciality, enroll_date)
VALUES ('AB', 1, true, 'S1', '2020-09-01');
INSERT INTO students(name, course, budget, speciality, enroll_date)
VALUES ('AC', 2, true, 'S1', '2019-09-02');
INSERT INTO students(name, course, budget, speciality, enroll_date)
VALUES ('AD', 3, true, 'M1', '2018-09-03');

update students set name = 'XXX' where enroll_date = '2018-09-03';
update students set name = 'YYY' where enroll_date = '2019-09-02';

begin transaction isolation level serializable;
select * from students;
drop table students cascade;