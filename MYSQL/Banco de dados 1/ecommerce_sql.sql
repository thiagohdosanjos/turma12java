create database ecommerce_sql;
use ecommerce_sql;

create table cadastro_produtos	(
	id int primary key auto_increment not null,
    produto varchar (255),
    tamanho enum ('P', 'M', 'G'),
    preco double (6,2),
    pagamento int  );
    
insert into cadastro_produtos values 
	(DEFAULT, 'Camiseta Supreme', 'P', '227.00',DEFAULT),
	(DEFAULT, 'Camiseta Lacoste', 'P', '342.00',DEFAULT),
	(DEFAULT, 'Moletom Supreme', 'M', '627.00',DEFAULT),
	(DEFAULT, 'Moletom LV', 'M', '9000.00',DEFAULT),
	(DEFAULT, 'Moletom Gucci', 'G', '8000.00',DEFAULT),
	(DEFAULT, 'Moletom Nike', 'P', '120.00',DEFAULT),
	(DEFAULT, 'Camiseta Gucci', 'G', '420.00',DEFAULT),
	(DEFAULT, 'Camiseta Prada', 'P', '450.00',DEFAULT);
    
select * from cadastro_produtos;

#drop table cadastro_produtos;

select * from cadastro_produtos where preco > 500.00;
select * from cadastro_produtos where preco < 500.00;

UPDATE cadastro_produtos SET preco = '8500.00' where produto = 'Moletom LV';

select * from cadastro_produtos;

    