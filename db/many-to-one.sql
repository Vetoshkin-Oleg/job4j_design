/*many-to-one
customer (Покупатель)
product (Продукт)
У одного покупателя может быть много купленных продуктов,
 при этом каждый продукт принадлежит только одному покупателю.*/

create table customer(
    id serial primary key,
    nameCustomer varchar(255)
);

create table product(
    id serial primary key,
    nameProduct varchar(255),
    price money,
    customer_id int references customer(id)
);

insert into customer(nameCustomer) values ('Ivan');
insert into product(nameProduct, customer_id) VALUES ('Apple', 1);

select * from product;

select * from customer
where id in (select customer_id from product);