//Tipo_cadastro
INSERT INTO tipo_cadastro(name) VALUES ('ENGENHEIRO');
INSERT INTO tipo_cadastro(name) VALUES ('ANALISTA');

//Cadastro
INSERT INTO cadastro(tipo_cadastro_id, contato, cpf_ou_cnpj, endereço) VALUES (1, 'Maria', '122.456.489-10', 'rua A');
INSERT INTO cadastro(tipo_cadastro_id, contato, cpf_ou_cnpj, endereço) VALUES (1, 'Bob', '000.155.00001.10', 'Av 30');
INSERT INTO cadastro(tipo_cadastro_id, contato, cpf_ou_cnpj, endereço) VALUES (2, 'Alex', '359.456.489-10', 'Alamenda dias 10');
INSERT INTO cadastro(tipo_cadastro_id, contato, cpf_ou_cnpj, endereço) VALUES (2, 'Ana', '1589.596.569-20', 'rua belmiro 59');

//Tipo_cliente
INSERT INTO tipo_cliente(name) VALUES ('Pessoa fisica');
INSERT INTO tipo_cliente(name) VALUES ('Pessoa jurídica');

//Cliente
INSERT INTO cliente(tipo_cliente_id, name, email) VALUES (1, 'Maria', 'maria@gmail.com');
INSERT INTO cliente(tipo_cliente_id, name, email) VALUES (1, 'Bob', 'bob@gmail.com');
INSERT INTO cliente(tipo_cliente_id, name, email) VALUES (2, 'Alex', 'alex@gmail.com');
INSERT INTO cliente(tipo_cliente_id, name, email) VALUES (2, 'Ana', 'ana@gmail.com');
