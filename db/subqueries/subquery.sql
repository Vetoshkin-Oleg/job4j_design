DROP TABLE customers CASCADE;
DROP TABLE orders CASCADE;

CREATE TABLE customers(
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);
INSERT INTO customers VALUES (1, 'Имя 1', 'Фамилия 1', 20, 'Страна 1');
INSERT INTO customers VALUES (2, 'Имя 2', 'Фамилия 2', 20, 'Страна 2');
INSERT INTO customers VALUES (3, 'Имя 3', 'Фамилия 4', 30, 'Страна 3');
INSERT INTO customers VALUES (4, 'Имя 4', 'Фамилия 4', 40, 'Страна 4');
INSERT INTO customers VALUES (5, 'Имя 5', 'Фамилия 5', 50, 'Страна 1');
INSERT INTO customers VALUES (6, 'Имя 6', 'Фамилия 6', 60, 'Страна 2');
INSERT INTO customers VALUES (7, 'Имя 7', 'Фамилия 7', 30, 'Страна 3');
INSERT INTO customers VALUES (8, 'Имя 8', 'Фамилия 8', 40, 'Страна 4');

SELECT * FROM customers
WHERE customers.age = (SELECT MIN(age) FROM customers);


CREATE TABLE orders(
    id serial primary key,
    amount int,
    customer_id int references customers(id)
);
INSERT INTO orders VALUES (1, 3, 1);
INSERT INTO orders VALUES (2, 5, 2);
INSERT INTO orders VALUES (3, 7, 3);
INSERT INTO orders VALUES (4, 6, 4);
INSERT INTO orders VALUES (8, 6, 8);

SELECT * FROM customers
WHERE id NOT IN (SELECT customer_id FROM orders);