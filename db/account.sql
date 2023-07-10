create table account(
	id serial primary key,
	open_date date,
	close_date date,
	avail_balance float,
    product_id int references product(id)
);

insert into account(open_date, close_date, avail_balance, product_id)
values ('2010-09-01', null, 100.75, 1);
insert into account(open_date, close_date, avail_balance, product_id)
values ('2010-10-01', '2011-10-01', 150.75, 1);
insert into account(open_date, close_date, avail_balance, product_id)
values ('2011-09-01', null, 200.75, 2);
insert into account(open_date, close_date, avail_balance, product_id)
values ('2011-10-01', '2012-10-01', 250.75, 2);
insert into account(open_date, close_date, avail_balance, product_id)
values ('2012-09-01', null, 300.75, 3);
insert into account(open_date, close_date, avail_balance, product_id)
values ('2012-10-01', '2013-10-01', 350.75, 3);
insert into account(open_date, close_date, avail_balance, product_id)
values ('2013-09-01', null, 400.75, 4);
insert into account(open_date, close_date, avail_balance, product_id)
values ('2013-10-01', '2014-10-01', 450.75, 4);
insert into account(open_date, close_date, avail_balance, product_id)
values ('2014-09-01', null, 500.75, 5);
insert into account(open_date, close_date, avail_balance, product_id)
values ('2014-10-01', '2015-10-01', 550.75, 5);
insert into account(open_date, close_date, avail_balance, product_id)
values ('2015-09-01', null, 600.75, 6);
insert into account(open_date, close_date, avail_balance, product_id)
values ('2015-10-01', '2016-10-01', 650.75, 6);

select a.open_date, a.avail_balance, pr.name
from account as a inner join product as pr
on a.product_id = pr.id;

select a.open_date, a.avail_balance, pr.name
from account as a inner join product as pr
on a.product_id = pr.id
where a.avail_balance > 300;

select a.open_date, a.avail_balance, pr.name
from account as a inner join product as pr
on a.product_id = pr.id
where a.close_date is not null;