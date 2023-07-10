create table product (
	id serial primary key,
	name text,
	date_offered date
 );

insert into product(name, date_offered)
values ('CHK', '2000-09-01');
insert into product(name, date_offered)
values ('SAV', '2000-08-01');
insert into product(name, date_offered)
values ('MM', '2000-07-01');
insert into product(name, date_offered)
values ('CD', '2000-06-01');
insert into product(name, date_offered)
values ('MRT', '2000-05-01');
insert into product(name, date_offered)
values ('AUT', '2000-04-01');

select * from product;