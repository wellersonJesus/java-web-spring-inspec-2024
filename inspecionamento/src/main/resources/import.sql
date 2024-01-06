--TipoCadastro
INSERT INTO tipo_cadastro(tipo_cadastro) VALUES ('Engenheiro');
INSERT INTO tipo_cadastro(tipo_cadastro) VALUES ('Tecnico');

--TipoCliente
INSERT INTO tipo_cliente(tipo_cliente) VALUES ('Pessoa fisica');
INSERT INTO tipo_cliente(tipo_cliente) VALUES ('Pessoa jurídica');

--Cliente
INSERT INTO cliente(tipo_cliente_id, nome, email) VALUES (1, 'Maria', 'maria@gmail.com');
INSERT INTO cliente(tipo_cliente_id, nome, email) VALUES (1, 'Bob', 'bob@gmail.com');
INSERT INTO cliente(tipo_cliente_id, nome, email) VALUES (2, 'Alex', 'alex@gmail.com');
INSERT INTO cliente(tipo_cliente_id, nome, email) VALUES (2, 'Ana', 'ana@gmail.com');

-- Cadastro
INSERT INTO cadastro(tipo_cadastro_id, nome, cpf_cnpj, endereco) VALUES (2, 'Maria', '057.895.879-10', 'rua 10 156');
INSERT INTO cadastro(tipo_cadastro_id, nome, cpf_cnpj, endereco) VALUES (1, 'Bob', '254.895.897.0001-66', 'av aboboras 25');
INSERT INTO cadastro(tipo_cadastro_id, nome, cpf_cnpj, endereco) VALUES (1, 'Alex', '032.458.587-25', 'alameda dias 10');
INSERT INTO cadastro(tipo_cadastro_id, nome, cpf_cnpj, endereco) VALUES (2, 'Ana', '595.568.254.0001-98', 'av bom sucesso');

--Inspecao
INSERT INTO inspecao(extraordinaria, inicial, periodica_interna_externa, cliente_id) VALUES ('Extra ADC', '2023-10-15', 'Periodica Casual', 2);
INSERT INTO inspecao(extraordinaria, inicial, periodica_interna_externa, cliente_id) VALUES ('Maico Dfc', '2023-06-18', 'Periodica Ambienta', 3);
INSERT INTO inspecao(extraordinaria, inicial, periodica_interna_externa, cliente_id) VALUES ('Jazz Coffe', '2023-03-30', 'Periodica Corrosivo', 1);
INSERT INTO inspecao(extraordinaria, inicial, periodica_interna_externa, cliente_id) VALUES ('Neintro', '2023-09-17', 'Periodica Estrutural', 4);
INSERT INTO inspecao(extraordinaria, inicial, periodica_interna_externa, cliente_id) VALUES ('Angary III', '2023-03-05', 'Periodica Passiva', 1);

--Equipamento
INSERT INTO equipamento(caldera, vaso_de_pressao, tubulacao, tanque_metalico, inspecao_id) VALUES ('Caldera Austriaca', 'vaso pressurizado', 'ANQ-10', 'tub-VCR', '2');
INSERT INTO equipamento(caldera, vaso_de_pressao, tubulacao, tanque_metalico, inspecao_id) VALUES ('Inova', 'Vaso Strep', 'ANQ-210', 'tub-DF', '3');
INSERT INTO equipamento(caldera, vaso_de_pressao, tubulacao, tanque_metalico, inspecao_id) VALUES ('Espa Kake', 'Press Cad', 'ANQ-0010', 'tub-HGT', '1');

--Caldera
INSERT INTO caldera(ano_fabricao, capacidade_producao_vapor_saturado, categoria, codigo_projeto_ano_edicao, combustivel, marca, modelo, numero_ordem, pressao_teste_hidrostatico_fabricante, pressao_efetiva_operacao, sup_aquecimento, equipamento_id) VALUES ('2023-02-09', 'Alta', 'B', 'AGH55', 'Alcool', 'DGTRH', 'A3', '847464744783', 'Alta controlada', 'Efetivado', 'Ativado', '1');
INSERT INTO caldera(ano_fabricao, capacidade_producao_vapor_saturado, categoria, codigo_projeto_ano_edicao, combustivel, marca, modelo, numero_ordem, pressao_teste_hidrostatico_fabricante, pressao_efetiva_operacao, sup_aquecimento, equipamento_id) VALUES ('2023-03-11', 'Baixa', 'A', 'DFR5', 'Etanol', 'FFFGG', 'C4', '568952274455', 'Baixa existente', 'Atuante', 'Desativado', '2');
















