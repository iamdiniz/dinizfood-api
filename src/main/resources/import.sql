insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Gourmet', 10, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Delivery', 9.50, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Tuk Tuk Comida Indiana', 15, 2);

insert into estado (nome) values ('São Paulo');
insert into estado (nome) values ('Minas Gerais');

insert into cidade (nome, estado_id) values ('Belo Horizonte', 2);
insert into cidade (nome, estado_id) values ('Guarulhos', 1);