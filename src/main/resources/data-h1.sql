INSERT INTO CLIENTE (id, nome, tipo_pessoa, cpf_cnpj, telefone, email)
VALUES ('1', 'Ana', 'FISICA', '000.000.000-04', '48984663454', 'ana@wmw.com.br');
INSERT INTO CLIENTE (id, nome, tipo_pessoa, cpf_cnpj, telefone, email)
VALUES ('2', 'Cesar', 'FISICA', '000.000.000-04', '48984663454', 'cesar@wmw.com.br');
INSERT INTO CLIENTE (id, nome, tipo_pessoa, cpf_cnpj, telefone, email)
VALUES ('3', 'Lucas', 'FISICA', '000.000.000-04', '48984663454', 'lucas@wmw.com.br');
INSERT INTO CLIENTE (id, nome, tipo_pessoa, cpf_cnpj, telefone, email)
VALUES ('4', 'WMW SYSTEMS', 'JURIDICA', '000.000.000-04', '48984663454','contato@wmw.com.br');

INSERT INTO PRODUTO (id, nome, preco)
VALUES ('1', 'Nivea Noturno', 22.0);
INSERT INTO PRODUTO (id, nome, preco)
VALUES ('2', 'Else Hidratação Noturna', 19.90);
INSERT INTO PRODUTO (id, nome, preco)
VALUES ('3', 'Perfume Shakira', 89.90);
INSERT INTO PRODUTO (id, nome, preco)
VALUES ('4', 'Creme HidraMais', 19.90);
INSERT INTO PRODUTO (id, nome, preco)
VALUES ('5', 'LipChilli FR', 35.90);
INSERT INTO PRODUTO (id, nome, preco)
VALUES ('6', 'Shampoo Elseve Intenso', 39.90);

INSERT INTO PEDIDO (id, id_cliente, data_emissao, data_entrega, total_pedido, status)
VALUES ('1', 1, DATE'2022-05-07', DATE'2022-05-07', 97.84, 'RASCUNHO');

INSERT INTO ITEM_PEDIDO (id, id_pedido, id_produto, quantidade, preco_unitario, desconto, total_item)
VALUES ('1', 1, 1, 3, 22.00, 0, 66.00);
INSERT INTO ITEM_PEDIDO (id, id_pedido, id_produto, quantidade, preco_unitario, desconto, total_item)
VALUES ('2', 1, 2, 4, 19.90, 0.4, 31.84);

INSERT INTO PEDIDO (id, id_cliente, data_emissao, data_entrega, total_pedido, status)
VALUES ('2', 2, DATE'2022-05-12', DATE'2022-05-17', 97.84, 'RASCUNHO');

INSERT INTO ITEM_PEDIDO (id, id_pedido, id_produto, quantidade, preco_unitario, desconto, total_item)
VALUES ('3', 2, 3, 3, 22.00, 0, 66.00);
INSERT INTO ITEM_PEDIDO (id, id_pedido, id_produto, quantidade, preco_unitario, desconto, total_item)
VALUES ('4', 2, 1, 4, 19.90, 0.4, 31.84);