CREATE table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

INSERT INTO products (name, producer, count, price)
    VALUES ('product_2', 'producer_2', 15, 32);
INSERT INTO products (name, producer, count, price)
    VALUES ('product_3', 'producer_3', 20, 40);
INSERT INTO products (name, producer, count, price)
    VALUES ('product_4', 'producer_4', 30, 50);

create or replace procedure delete_data()
language 'plpgsql'
as $$
    BEGIN
    DELETE FROM products WHERE price < 41;
    END
$$;

call delete_data();

create or replace function delete_data_func()
returns void
language 'plpgsql'
as
$$
    begin
        delete from products where price < 41;
    end;
$$;

select delete_data_func();