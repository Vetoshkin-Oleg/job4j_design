insert into users(name) values ('Ivan');
insert into roles(name, user_id) VALUES ('programmer', 1);
insert into rules(name) values ('RULES');
insert into roles_rules(roles_id, rules_id) VALUES (1, 1);
insert into items(name, user_id) VALUES ('ITEM', 1);
insert into comments(name, item_id) VALUES ('COMMENT', 1);
insert into attachs(name, item_id) VALUES ('ATTACH', 1);
insert into states(name, item_id) VALUES ('STATE', 1);
insert into categories(name, item_id) VALUES ('CATEGORIES', 1);