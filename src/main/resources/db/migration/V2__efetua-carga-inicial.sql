insert into cliente (nome) values ('ANA');  -- id 1
insert into cliente (nome) values ('BIA');  -- id 2
insert into cliente (nome) values ('CAIO'); -- id 3
insert into cliente (nome) values ('DANI'); -- id 4
insert into cliente (nome) values ('ELI');  -- id 5
insert into cliente (nome) values ('GABI'); -- id 6

insert into categoria (nome) values ('AUTOMOTIVA');  -- id 1
insert into categoria (nome) values ('CELULARES');   -- id 2
insert into categoria (nome) values ('INFORMÁTICA'); -- id 3
insert into categoria (nome) values ('LIVROS');      -- id 4
insert into categoria (nome) values ('MÓVEIS');      -- id 5

INSERT INTO produto (nome, preco, categoria_id) VALUES ('Notebook Samsung', 3523.0, 3);                                 -- id 1
INSERT INTO produto (nome, preco, categoria_id) VALUES ('Sofá 3 lugares', 2500.0, 5);                                   -- id 2
INSERT INTO produto (nome, preco, categoria_id) VALUES ('Clean Architecture', 102.9, 4);                                -- id 3
INSERT INTO produto (nome, preco, categoria_id) VALUES ('Mesa de jantar 6 lugares', 3678.98, 5);                        -- id 4
INSERT INTO produto (nome, preco, categoria_id) VALUES ('iPhone 13 Pro', 9176.0, 2);                                    -- id 5
INSERT INTO produto (nome, preco, categoria_id) VALUES ('Monitor Dell 27"', 1889.0, 3);                                 -- id 6
INSERT INTO produto (nome, preco, categoria_id) VALUES ('Implementing Domain-Driven Design', 144.07, 4);                -- id 7
INSERT INTO produto (nome, preco, categoria_id) VALUES ('Jogo de pneus', 1276.79, 1);                                   -- id 8
INSERT INTO produto (nome, preco, categoria_id) VALUES ('Clean Code', 95.17, 4);                                        -- id 9
INSERT INTO produto (nome, preco, categoria_id) VALUES ('Galaxy S22 Ultra', 8549.1, 2);                                 -- id 10
INSERT INTO produto (nome, preco, categoria_id) VALUES ('Macbook Pro 16', 31752.0, 3);                                  -- id 11
INSERT INTO produto (nome, preco, categoria_id) VALUES ('Refactoring Improving the Design of Existing Code', 173.9, 4); -- id 12
INSERT INTO produto (nome, preco, categoria_id) VALUES ('Cama queen size', 3100.0, 5);                                  -- id 13
INSERT INTO produto (nome, preco, categoria_id) VALUES ('Central multimidia', 711.18, 1);                               -- id 14
INSERT INTO produto (nome, preco, categoria_id) VALUES ('Building Microservices', 300.28, 4);                           -- id 15
INSERT INTO produto (nome, preco, categoria_id) VALUES ('Galaxy Tab S8', 5939.1, 3);                                    -- id 16

INSERT INTO pedido (cliente_id, data) VALUES (1, '2022-01-01');  -- id 1
INSERT INTO pedido (cliente_id, data) VALUES (1, '2022-01-05');  -- id 2
INSERT INTO pedido (cliente_id, data) VALUES (1, '2022-01-08');  -- id 3
INSERT INTO pedido (cliente_id, data) VALUES (5, '2022-01-06');  -- id 4
INSERT INTO pedido (cliente_id, data) VALUES (1, '2022-01-13');  -- id 5
INSERT INTO pedido (cliente_id, data) VALUES (4, '2022-01-04');  -- id 6
INSERT INTO pedido (cliente_id, data) VALUES (6, '2022-01-10');  -- id 7
INSERT INTO pedido (cliente_id, data) VALUES (2, '2022-01-15');  -- id 8
INSERT INTO pedido (cliente_id, data) VALUES (2, '2022-01-09');  -- id 9
INSERT INTO pedido (cliente_id, data) VALUES (4, '2022-01-14'); -- id 10
INSERT INTO pedido (cliente_id, data) VALUES (3, '2022-01-03'); -- id 11
INSERT INTO pedido (cliente_id, data) VALUES (4, '2022-01-12'); -- id 12
INSERT INTO pedido (cliente_id, data) VALUES (4, '2022-01-07'); -- id 13
INSERT INTO pedido (cliente_id, data) VALUES (3, '2022-01-16'); -- id 14
INSERT INTO pedido (cliente_id, data) VALUES (3, '2022-01-11'); -- id 15
INSERT INTO pedido (cliente_id, data) VALUES (2, '2022-01-02'); -- id 16

INSERT INTO item_pedido (pedido_id, produto_id, preco_compra, quantidade) VALUES (1, 1, 3523.0, 1);
INSERT INTO item_pedido (pedido_id, produto_id, preco_compra, quantidade) VALUES (2, 2, 2500.0, 1);
INSERT INTO item_pedido (pedido_id, produto_id, preco_compra, quantidade) VALUES (3, 3, 102.9, 2);
INSERT INTO item_pedido (pedido_id, produto_id, preco_compra, quantidade) VALUES (4, 4, 3678.98, 1);
INSERT INTO item_pedido (pedido_id, produto_id, preco_compra, quantidade) VALUES (5, 5, 9176.0, 6);
INSERT INTO item_pedido (pedido_id, produto_id, preco_compra, quantidade) VALUES (6, 6, 1889.0, 3);
INSERT INTO item_pedido (pedido_id, produto_id, preco_compra, quantidade) VALUES (7, 7, 144.07, 3);
INSERT INTO item_pedido (pedido_id, produto_id, preco_compra, quantidade) VALUES (8, 8, 1276.79, 1);
INSERT INTO item_pedido (pedido_id, produto_id, preco_compra, quantidade) VALUES (9, 9, 95.17, 1);
INSERT INTO item_pedido (pedido_id, produto_id, preco_compra, quantidade) VALUES (10, 10, 8549.1, 5);
INSERT INTO item_pedido (pedido_id, produto_id, preco_compra, quantidade) VALUES (11, 11, 31752.0, 1);
INSERT INTO item_pedido (pedido_id, produto_id, preco_compra, quantidade) VALUES (12, 12, 173.9, 1);
INSERT INTO item_pedido (pedido_id, produto_id, preco_compra, quantidade) VALUES (13, 13, 3100.0, 2);
INSERT INTO item_pedido (pedido_id, produto_id, preco_compra, quantidade) VALUES (14, 14, 711.18, 1);
INSERT INTO item_pedido (pedido_id, produto_id, preco_compra, quantidade) VALUES (15, 15, 300.28, 2);
INSERT INTO item_pedido (pedido_id, produto_id, preco_compra, quantidade) VALUES (16, 16, 5939.1, 4);
commit;