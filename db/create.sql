CREATE table roles(
id serial primary key,
name varchar(255)
);
CREATE table users(
id serial primary key,
name varchar(255),
role_id int references roles(id)
);
CREATE table rules(
id serial primary key,
name varchar(255)
);
CREATE table roles_rules(
id serial primary key,
role_id int references roles(id),
rule_id int references rules(id)
);
CREATE table categories(
id serial primary key,
name varchar(255)
);
CREATE table states(
id serial primary key,
name varchar(255)
);
CREATE table items(
id serial primary key,
name varchar(255),
user_id int references users(id),
categories_id int references categories(id),
states_id int references states(id)
);
CREATE table comments(
id serial primary key,
name varchar(255),
item_id int references items(id)
);
CREATE table attachs(
id serial primary key,
name varchar(255),
item_id int references items(id)
);