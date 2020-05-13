set foreign_key_checks = 0;

delete from estoque;
delete from produto;
delete from filial;
delete from nota;

set foreign_key_checks = 1;

alter table estoque auto_increment = 1;
alter table produto auto_increment = 1;
alter table filial auto_increment = 1;
alter table nota auto_increment = 1;

insert into filial (id, nome) values (1, 'Scranton');
insert into filial (id, nome) values (2, 'Nashua');
insert into filial (id, nome) values (3, 'Utica');

insert into produto (id, nome, preco) values (1, 'plain white paper', 0.15);
insert into produto (id, nome, preco) values (2, 'plain green paper', 0.35);
insert into produto (id, nome, preco) values (3, 'plain pink paper', 0.45);
insert into produto (id, nome, preco) values (4, 'beveled paper', 0.45);

insert into estoque (id, filial_id, produto_id, quantidade) values (1, 1, 1, 3500);
insert into estoque (id, filial_id, produto_id, quantidade) values (2, 1, 2, 1000);
insert into estoque (id, filial_id, produto_id, quantidade) values (3, 1, 3, 1500);
insert into estoque (id, filial_id, produto_id, quantidade) values (4, 1, 4, 2500);

insert into estoque (id, filial_id, produto_id, quantidade) values (5, 2, 1, 3331);
insert into estoque (id, filial_id, produto_id, quantidade) values (6, 2, 3, 25000);
insert into estoque (id, filial_id, produto_id, quantidade) values (7, 3, 1, 1111);
insert into estoque (id, filial_id, produto_id, quantidade) values (8, 3, 4, 500);