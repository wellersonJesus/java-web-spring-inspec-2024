-- TipoCadastro
INSERT INTO tipo_cadastro(tipo_cadastro) VALUES ('Engenheiro');
INSERT INTO tipo_cadastro(tipo_cadastro) VALUES ('Tecnico');

-- Cadastro
INSERT INTO cadastro(tipo_cadastro_id, nome, cpf_cnpj, endereco) VALUES (2, 'Maria', '057.895.879-10', 'rua 10 156');
INSERT INTO cadastro(tipo_cadastro_id, nome, cpf_cnpj, endereco) VALUES (1, 'Bob', '254.895.897.0001-66', 'av aboboras 25');
INSERT INTO cadastro(tipo_cadastro_id, nome, cpf_cnpj, endereco) VALUES (1, 'Alex', '032.458.587-25', 'alameda dias 10');
INSERT INTO cadastro(tipo_cadastro_id, nome, cpf_cnpj, endereco) VALUES (2, 'Ana', '595.568.254.0001-98', 'av bom sucesso');

--TipoCliente
INSERT INTO tipo_cliente(tipo_cliente) VALUES ('Pessoa fisica');
INSERT INTO tipo_cliente(tipo_cliente) VALUES ('Pessoa jurídica');

--Cliente
INSERT INTO cliente(tipo_cliente_id, name, email) VALUES (1, 'Maria', 'maria@gmail.com');
INSERT INTO cliente(tipo_cliente_id, name, email) VALUES (1, 'Bob', 'bob@gmail.com');
INSERT INTO cliente(tipo_cliente_id, name, email) VALUES (2, 'Alex', 'alex@gmail.com');
INSERT INTO cliente(tipo_cliente_id, name, email) VALUES (2, 'Ana', 'ana@gmail.com');