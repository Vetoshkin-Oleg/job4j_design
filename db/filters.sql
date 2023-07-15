create table type(
    id serial primary key,
    name text
);

create table product(
    id serial primary key,
    name text,
    expired_date date,
    price float,
    type_id int references type(id)
);

insert into type(name) values ('Фрукты и овощи');
insert into type(name) values ('Мясо');
insert into type(name) values ('Молоко');
insert into type(name) values ('Сыр');
insert into type(name) values ('Замороженная продукция');

insert into product(name, expired_date, price, type_id)
 values ('Нектарины', '2023-08-13', 119.99, 1);
insert into product(name, expired_date, price, type_id)
 values ('Томаты розовые', '2023-07-20', 169.99, 1);
insert into product(name, expired_date, price, type_id)
 values ('Абрикосы', '2023-07-20', 179.99, 1);
insert into product(name, expired_date, price, type_id)
 values ('Томаты махитос', '2023-07-10', 209.99, 1);
insert into product(name, expired_date, price, type_id)
 values ('Томаты кривянские', '2023-08-10', 209.99, 1);
insert into product(name, expired_date, price, type_id)
 values ('Огурцы', '2023-07-05', 89.99, 1);

insert into product(name, expired_date, price, type_id)
 values ('Карбонат из свинины', '2023-08-13', 289.00, 2);
insert into product(name, expired_date, price, type_id)
 values ('Окорок свиной', '2023-08-14', 319.99, 2);
insert into product(name, expired_date, price, type_id)
 values ('Шея свиная', '2023-07-11', 499.99, 2);
insert into product(name, expired_date, price, type_id)
 values ('Тушка цыпленка', '2023-07-15', 199.99, 2);
insert into product(name, expired_date, price, type_id)
 values ('Филе грудки индейки', '2023-07-16', 379.99, 2);
insert into product(name, expired_date, price, type_id)
 values ('Лопатка свиная', '2023-07-12', 289.99, 2);
insert into product(name, expired_date, price, type_id)
 values ('Шашлык из свиной шеи', '2023-07-17', 499.99, 2);
insert into product(name, expired_date, price, type_id)
 values ('Буженина запеченая', '2023-08-17', 1699.99, 2);

insert into product(name, expired_date, price, type_id)
 values ('Молоко ультрапастеризованное Домик', '2023-07-17', 89.99, 3);
insert into product(name, expired_date, price, type_id)
 values ('Молоко пастеризованное Простоквашино', '2023-07-12', 76.99, 3);
insert into product(name, expired_date, price, type_id)
 values ('Молоко пастеризованное Домик', '2023-07-11', 124.99, 3);
insert into product(name, expired_date, price, type_id)
 values ('Молоко пастеризованное Правильное', '2023-07-21', 164.99, 3);
insert into product(name, expired_date, price, type_id)
 values ('Молоко пастеризованное ЭКОНИВА', '2023-07-17', 74.99, 3);
insert into product(name, expired_date, price, type_id)
 values ('Молоко ультрапастеризованное ЭКОНИВА', '2023-07-21', 69.99, 3);
insert into product(name, expired_date, price, type_id)
 values ('Молоко пастеризованное НАШЕ ДЕЛО', '2023-07-17', 64.99, 3);
insert into product(name, expired_date, price, type_id)
 values ('Молоко ультрапастеризованное Comfort', '2023-07-21', 114.99, 3);
insert into product(name, expired_date, price, type_id)
 values ('Молоко пастеризованное СЕЛО ЗЕЛЕНОЕ', '2023-07-17', 144.99, 3);
insert into product(name, expired_date, price, type_id)
 values ('Молоко пастеризованное МУ-У', '2023-07-24', 69.99, 3);

insert into product(name, expired_date, price, type_id)
 values ('Сыр САРМИЧ Тильзитер', '2023-06-15', 749.99, 4);
insert into product(name, expired_date, price, type_id)
 values ('Сыр РОССИЙСКИЙ', '2023-07-07', 464.99, 4);
insert into product(name, expired_date, price, type_id)
 values ('Сыр GALBANI', '2023-08-14', 159.99, 4);
insert into product(name, expired_date, price, type_id)
 values ('Сыр LA PAULINA', '2023-08-14', 1699.99, 4);
insert into product(name, expired_date, price, type_id)
 values ('Сыр 365 ДНЕЙ', '2024-07-14', 99.99, 4);
insert into product(name, expired_date, price, type_id)
 values ('Сыр Маасдам', '2023-08-14', 799.99, 4);
insert into product(name, expired_date, price, type_id)
 values ('Сыр ЧИЗОЛИНИ', '2023-08-14', 165.99, 4);
insert into product(name, expired_date, price, type_id)
 values ('Сыр ЛАМБЕР', '2023-08-14', 249.99, 4);
insert into product(name, expired_date, price, type_id)
 values ('Сыр NATURA', '2023-08-14', 779.99, 4);
insert into product(name, expired_date, price, type_id)
 values ('Сыр VIOLA', '2023-08-14', 229.99, 4);
insert into product(name, expired_date, price, type_id)
 values ('Сыр ЛЕНТА', '2023-08-14', 869.99, 4);

insert into product(name, expired_date, price, type_id)
 values ('Мороженое ФИЛЕВСКОЕ', '2023-06-14', 37.99, 5);
insert into product(name, expired_date, price, type_id)
 values ('Мороженое КОРОВКА ИЗ КОРЕНОВКИ', '2023-06-14', 68.99, 5);
insert into product(name, expired_date, price, type_id)
 values ('МороЖЕНОЕ MILKA Ванильное', '2023-06-14', 77.99, 5);
insert into product(name, expired_date, price, type_id)
 values ('МороЖЕНОЕ Лента Пломбир', '2023-08-14', 48.99, 5);
insert into product(name, expired_date, price, type_id)
 values ('МороЖЕНОЕ MAXIDUO', '2023-08-14', 89.99, 5);
insert into product(name, expired_date, price, type_id)
 values ('МороЖЕНОЕ ЧИСТАЯ ЛИНИЯ', '2023-08-14', 111.99, 5);
insert into product(name, expired_date, price, type_id)
 values ('МороЖЕНОЕ 48 КОПЕЕК', '2023-08-14', 139.99, 5);
insert into product(name, expired_date, price, type_id)
 values ('МороЖЕНОЕ Магнат', '2023-08-14', 129.99, 5);
insert into product(name, expired_date, price, type_id)
 values ('Мороженое NESTLE', '2023-08-14', 69.99, 5);
insert into product(name, expired_date, price, type_id)
 values ('МОРОженое ЗОЛОТОЙ СТАНДАРТ', '2023-08-14', 74.99, 5);
insert into product(name, expired_date, price, type_id)
 values ('Мороженое OREO', '2023-08-14', 79.99, 5);
insert into product(name, expired_date, price, type_id)
 values ('МороЖЕНОЕ SNICKERS', '2023-08-14', 119.99, 5);

/*1. Написать запрос получение всех продуктов с типом "СЫР"*/
select * from type t
join product p
on t.id = p.type_id
where upper(t.name) = 'СЫР';

/*2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"*/
select * from product p
where lower(p.name) like '%мороженое%';

/*3. Написать запрос, который выводит все продукты, срок годности которых уже истек*/
select * from product p
where current_date > p.expired_date;

/*4. Написать запрос, который выводит самый дорогой продукт.
Запрос должен быть универсальный и находить все продукты с максимальной ценой*/
select * from product
where product.price = (select max(product.price) from product);

/*5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих.
В виде имя_типа, количество*/
select t.name, count(*) from product p
join type t
on t.id = p.type_id
group by t.name;

/*6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"*/
select * from type t
join product p
on t.id = p.type_id
where upper(t.name) in ('СЫР', 'МОЛОКО');

/*7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
Под количеством подразумевается количество продуктов определенного типа.
Например, если есть тип "СЫР" и продукты "Сыр плавленный" и "Сыр моцарелла",
которые ему принадлежат, то количество продуктов типа "СЫР" будет 2.*/
select t.name, count(*) from product p
join type t
on t.id = p.type_id
group by t.name
having count(*) < 10;

/*8. Вывести все продукты и их тип.*/
select p.name, t.name from type t
join product p
on t.id = p.type_id;