create table people(
    id serial primary key,
    name varchar(255),
    birth date,
    bill int
);

insert into people(name, birth, bill) values('Олег', 'January 8, 1999', 100);
select * from people;
update people set bill = 300;
select * from people;
delete from people;
select * from people;