INSERT INTO tipo_cliente(name) VALUES ('Pessoa fisica');
INSERT INTO tipo_cliente(name) VALUES ('Pessoa jurídica');

INSERT INTO cliente(tipo_cliente_id, name, email) VALUES (1, 'Maria', 'maria@gmail.com');
INSERT INTO cliente(tipo_cliente_id, name, email) VALUES (1, 'Bob', 'bob@gmail.com');
INSERT INTO cliente(tipo_cliente_id, name, email) VALUES (2, 'Alex', 'alex@gmail.com');
INSERT INTO cliente(tipo_cliente_id, name, email) VALUES (2, 'Ana', 'ana@gmail.com');
