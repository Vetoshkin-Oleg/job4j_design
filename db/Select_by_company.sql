CREATE TABLE company(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

select * from company;
select * from person;

INSERT INTO company(id, name) VALUES (1, 'company_1');
INSERT INTO company(id, name) VALUES (2, 'company_2');
INSERT INTO company(id, name) VALUES (3, 'company_3');
INSERT INTO company(id, name) VALUES (4, 'company_4');
INSERT INTO company(id, name) VALUES (5, 'company_5');
INSERT INTO company(id, name) VALUES (6, 'company_6');

INSERT INTO person(id, name, company_id) VALUES (1, 'person_1', 1);
INSERT INTO person(id, name, company_id) VALUES (2, 'person_2', 2);
INSERT INTO person(id, name, company_id) VALUES (3, 'person_3', 3);
INSERT INTO person(id, name, company_id) VALUES (4, 'person_4', 3);
INSERT INTO person(id, name, company_id) VALUES (5, 'person_5', 4);
INSERT INTO person(id, name, company_id) VALUES (6, 'person_6', 4);
INSERT INTO person(id, name, company_id) VALUES (7, 'person_7', 4);
INSERT INTO person(id, name, company_id) VALUES (8, 'person_8', 5);
INSERT INTO person(id, name, company_id) VALUES (9, 'person_9', 5);
INSERT INTO person(id, name, company_id) VALUES (10, 'person_10', 5);
INSERT INTO person(id, name, company_id) VALUES (11, 'person_11', 5);
INSERT INTO person(id, name, company_id) VALUES (12, 'person_12', 6);
INSERT INTO person(id, name, company_id) VALUES (13, 'person_13', 6);
INSERT INTO person(id, name, company_id) VALUES (14, 'person_14', 6);
INSERT INTO person(id, name, company_id) VALUES (15, 'person_15', 6);

/*1. В одном запросе получить
- имена всех person, которые не состоят в компании с id = 5;
- название компании для каждого человека.*/
select person.name, company.name
from person join company
on person.company_id = company.id
where company.id != 5;

/*2. Необходимо выбрать название компании с максимальным количеством человек
+ количество человек в этой компании.
Нужно учесть, что таких компаний может быть несколько.*/
