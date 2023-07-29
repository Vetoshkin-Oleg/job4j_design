INSERT INTO roles(name) VALUES ('programmer');
INSERT INTO users(name, role_id) VALUES ('Ivan', 1);
INSERT INTO rules(name) VALUES ('RULES');
INSERT INTO roles_rules(role_id, rule_id) VALUES (1, 1);
INSERT INTO categories(name) VALUES ('CATEGORIES');
INSERT INTO states(name) VALUES ('STATE');
INSERT INTO items(name, user_id, categories_id, states_id) VALUES ('ITEM', 1, 1, 1);
INSERT INTO comments(name, item_id) VALUES ('COMMENT', 1);
INSERT INTO attachs(name, item_id) VALUES ('ATTACH', 1);