CREATE table car_bodies(
    id serial primary key,
    name varchar(255)
);
CREATE table car_engines(
    id serial primary key,
    name varchar(255)
);
CREATE table car_transmissions(
    id serial primary key,
    name varchar(255)
);
CREATE table cars(
    id serial primary key,
    name varchar(255),
	body_id int references car_bodies(id),
	engine_id int references car_engines(id),
	transmission_id int references car_transmissions(id)
);

INSERT INTO car_bodies(name) VALUES ('bodies_1');
INSERT INTO car_bodies(name) VALUES ('bodies_2');
INSERT INTO car_bodies(name) VALUES ('bodies_3');
INSERT INTO car_bodies(name) VALUES ('bodies_4');
INSERT INTO car_engines(name) VALUES ('engines_1');
INSERT INTO car_engines(name) VALUES ('engines_2');
INSERT INTO car_engines(name) VALUES ('engines_3');
INSERT INTO car_engines(name) VALUES ('engines_4');
INSERT INTO car_transmissions(name) VALUES ('transmissions_1');
INSERT INTO car_transmissions(name) VALUES ('transmissions_2');
INSERT INTO car_transmissions(name) VALUES ('transmissions_3');
INSERT INTO car_transmissions(name) VALUES ('transmissions_34');
INSERT INTO cars(name, body_id, engine_id, transmission_id) VALUES ('car_1', 1, 2, 3);
INSERT INTO cars(name, body_id, engine_id, transmission_id) VALUES ('car_2', 2, 3, 1);
INSERT INTO cars(name, body_id, engine_id, transmission_id) VALUES ('car_3', 3, 1, NULL);
INSERT INTO cars(name, body_id, engine_id, transmission_id) VALUES ('car_4', 1, NULL, NULL);

SELECT * FROM car_bodies;
SELECT * FROM car_engines;
SELECT * FROM car_transmissions;
SELECT * FROM cars;

SELECT cars.id AS id, cars.name AS car_name, car_bodies.name AS body_name,
car_engines.name AS engine_name, car_transmissions.name AS transmission_name
FROM cars LEFT JOIN car_bodies
ON cars.body_id = car_bodies.id
LEFT JOIN car_engines
ON cars.engine_id = car_engines.id
LEFT JOIN car_transmissions
ON cars.transmission_id = car_transmissions.id;

SELECT car_bodies.name FROM car_bodies
LEFT JOIN cars
ON car_bodies.id = cars.body_id
WHERE cars.body_id IS NULL;

SELECT car_engines.name FROM car_engines
LEFT JOIN cars
ON car_engines.id = cars.body_id
WHERE cars.body_id IS NULL;

SELECT car_transmissions.name FROM car_transmissions
LEFT JOIN cars
ON car_transmissions.id = cars.body_id
WHERE cars.body_id IS NULL;

DROP TABLE car_bodies;
DROP TABLE car_engines;
DROP TABLE car_transmissions;
DROP TABLE cars;