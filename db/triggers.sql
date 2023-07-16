CREATE table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create trigger tax_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax();

create or replace function tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.4
        where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger_row
    before insert
    on products
    for each row
    execute function tax_row();

create or replace function tax_row()
    returns trigger as
$$
    BEGIN
		NEW.price = NEW.price + NEW.price * 0.3;
		return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

create trigger history_trigger
    after insert
    on products
    for each row
    execute procedure history();

create or replace function history()
    returns trigger as
$$
    BEGIN
        INSERT INTO history_of_price(name, price, date)
		VALUES(NEW.name, NEW.price, now());
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

insert into products (name, producer, count, price) VALUES ('product_4', 'producer_4', 8, 200);
select * from products;
select * from history_of_price;

drop trigger tax_trigger on products;
drop trigger tax_trigger_row on products;
drop table products;
drop trigger history_trigger on history_of_price;
drop table history_of_price;