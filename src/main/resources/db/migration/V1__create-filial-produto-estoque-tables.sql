create table filial (
	id BIGINT not null auto_increment,
	nome varchar(45) not null,

	primary key (id)
) engine=InnoDB default charset=utf8;


create table produto (
	id BIGINT not null auto_increment,
	nome varchar(45) not null,
	preco decimal(10,2) not null,

	primary key (id)
) engine=InnoDB default charset=utf8;

create table estoque (
	id BIGINT not null auto_increment,
	filial_id BIGINT not null,
	produto_id BIGINT not null,
	quantidade BIGINT not null,

	primary key (id)
) engine=InnoDB default charset=utf8;

create table nota (
	id BIGINT not null auto_increment,
	numero_nota_fiscal varchar(200) not null,
	produto_id BIGINT not null,

	primary key (id)
) engine=InnoDB default charset=utf8;

alter table estoque add constraint estoque_filial_fk
foreign key (filial_id) references filial(id);

alter table estoque add constraint estoque_produto_fk
foreign key (produto_id) references produto(id);

alter table nota add constraint nota_produto_fk
foreign key (produto_id) references produto(id);