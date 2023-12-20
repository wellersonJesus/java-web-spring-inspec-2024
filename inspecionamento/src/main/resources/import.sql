-- Inserir tipos de cadastro
INSERT INTO tipo_cadastro (name) VALUES ('engenheiro');
INSERT INTO tipo_cadastro (name) VALUES ('tecnico');

-- Inserir dados na tabela cadastro
INSERT INTO cadastro (tipo_cadastro_id, contato, cpfoucnpj, endereco) VALUES (1, 'Maria', '000034120000100', 'Rua A');
INSERT INTO cadastro (tipo_cadastro_id, contato, cpfoucnpj, endereco) VALUES (1, 'Antonio', '526894120000100', 'Rua B');
INSERT INTO cadastro (tipo_cadastro_id, contato, cpfoucnpj, endereco) VALUES (2, 'Gleiso', '04522255510', 'Rua C');
INSERT INTO cadastro (tipo_cadastro_id, contato, cpfoucnpj, endereco) VALUES (2, 'Carlos', '12558955525', 'Rua D');
INSERT INTO cadastro (tipo_cadastro_id, contato, cpfoucnpj, endereco) VALUES (1, 'Bruno', '568589120000100', 'Rua E');

-- Inserir dados na tabela cliente
INSERT INTO tipo_cliente (pessoa_fisica, pessoa_juridica) VALUES ('Engenheiro', null);
INSERT INTO tipo_cliente (pessoa_fisica, pessoa_juridica) VALUES (null, 'Técnico');

-- Inserir dados na tabela cliente
INSERT INTO cliente (nome, email, tipo_cliente_id) VALUES ('Maria', 'maria@example.com', 1);
INSERT INTO cliente (nome, email, tipo_cliente_id) VALUES ('Antonio', 'antonio@example.com', 1);
INSERT INTO cliente (nome, email, tipo_cliente_id) VALUES ('Gleiso', 'gleiso@example.com', 2);
INSERT INTO cliente (nome, email, tipo_cliente_id) VALUES ('Carlos', 'carlos@example.com', 2);
INSERT INTO cliente (nome, email, tipo_cliente_id) VALUES ('Bruno', 'bruno@example.com', 1);
