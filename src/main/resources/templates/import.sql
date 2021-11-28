DROP TABLE users IF EXISTS;
CREATE TABLE IF NOT EXISTS users (id bigserial, score int, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO users (name, score) VALUES ('Bob', 80), ('Jack', 80), ('John', 80);

CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), price int, PRIMARY KEY(id));
INSERT INTO products (title, price) VALUES ('Bread', 100), ('Bread Luxury', 200), ('Apple', 100), ('Milk', 70), ('Eggs', 100);
