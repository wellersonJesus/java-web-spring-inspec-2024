-- Inserir tipos de cadastro
INSERT INTO tipo_cadastro (engenheiro) VALUES ('engenheiro');
INSERT INTO tipo_cadastro (tecnico) VALUES ('tecnico');

-- Inserir dados na tabela cadastro
INSERT INTO cadastro (tipo_cadastro_id, contato, cpfoucnpj, endereco) VALUES (1, 'Maria', '000034120000100', 'Rua A');
INSERT INTO cadastro (tipo_cadastro_id, contato, cpfoucnpj, endereco) VALUES (1, 'Antonio', '526894120000100', 'Rua B');
INSERT INTO cadastro (tipo_cadastro_id, contato, cpfoucnpj, endereco) VALUES (2, 'Gleiso', '04522255510', 'Rua C');
INSERT INTO cadastro (tipo_cadastro_id, contato, cpfoucnpj, endereco) VALUES (2, 'Carlos', '12558955525', 'Rua D');
INSERT INTO cadastro (tipo_cadastro_id, contato, cpfoucnpj, endereco) VALUES (1, 'Bruno', '568589120000100', 'Rua E');


