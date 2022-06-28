INSERT INTO CLIENTE (nome, tipo_pessoa, cpf_cnpj, telefone, email)
VALUES ('Ana', 'FISICA', '000.000.000-04', '48984663454', 'ana@wmw.com.br');
INSERT INTO CLIENTE (nome, tipo_pessoa, cpf_cnpj, telefone, email)
VALUES ('Cesar', 'FISICA', '000.000.000-04', '48984663454', 'cesar@wmw.com.br');
INSERT INTO CLIENTE (nome, tipo_pessoa, cpf_cnpj, telefone, email)
VALUES ('Lucas', 'FISICA', '000.000.000-04', '48984663454', 'lucas@wmw.com.br');
INSERT INTO CLIENTE (nome, tipo_pessoa, cpf_cnpj, telefone, email)
VALUES ('WMW SYSTEMS', 'JURIDICA', '000.000.000-04', '48984663454','contato@wmw.com.br');

INSERT INTO PRODUTO (nome, preco)
VALUES ('Nivea Noturno', 22.0);
INSERT INTO PRODUTO (nome, preco)
VALUES ('Else Hidratação Noturna', 19.90);
INSERT INTO PRODUTO (nome, preco)
VALUES ('Perfume Shakira', 89.90);
INSERT INTO PRODUTO (nome, preco)
VALUES ('Creme HidraMais', 19.90);
INSERT INTO PRODUTO (nome, preco)
VALUES ('LipChilli FR', 35.90);
INSERT INTO PRODUTO (nome, preco)
VALUES ('Shampoo Elseve Intenso', 39.90);

INSERT INTO PEDIDO (id_cliente, data_emissao, data_entrega, total_pedido, status)
VALUES (1, GETDATE(), DATEADD(DD,4,GETDATE()), 97.84, 'RASCUNHO');

INSERT INTO ITEM_PEDIDO (id_pedido, id_produto, quantidade, preco_unitario, desconto, total_item)
VALUES (1, 1, 3, 22.00, 0, 66.00);
INSERT INTO ITEM_PEDIDO (id_pedido, id_produto, quantidade, preco_unitario, desconto, total_item)
VALUES (1, 2, 4, 19.90, 0.4, 31.84);

INSERT INTO PEDIDO (id_cliente, data_emissao, data_entrega, total_pedido, status)
VALUES (2, GETDATE(), DATEADD(DD,4,GETDATE()), 97.84, 'RASCUNHO');

INSERT INTO ITEM_PEDIDO (id_pedido, id_produto, quantidade, preco_unitario, desconto, total_item)
VALUES (2, 3, 3, 22.00, 0, 66.00);
INSERT INTO ITEM_PEDIDO (id_pedido, id_produto, quantidade, preco_unitario, desconto, total_item)
VALUES (2, 1, 4, 19.90, 0.4, 31.84);