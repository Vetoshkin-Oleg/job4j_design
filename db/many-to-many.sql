/*many-to-many
Building (Здание для размещения арендаторов)
Tenant (Арендатор – сеть магазинов)
В здании может быть множество арендаторов (например, торговых сетей).
 В то же время, каждый арендатор (торговая сеть) может быть представлен во множестве зданий.*/

create table building(
     id serial primary key,
     area varchar(255)
 );

 create table tenant(
     id serial primary key,
     name varchar(255)
 );

 create table building_tenant(
     id serial primary key,
     building_id int references building(id),
     tenant_id int references tenant(id)
 );