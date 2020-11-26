CREATE database rh_funcionarios;
use rh_funcionarios;

CREATE TABLE funcionarios 	(
	idPessoa int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nomeFuncionario varchar (55),
    cargo varchar (50),
    genero char,
    cpf varchar (100),
    salario decimal (6,2));
    
insert into funcionarios values 
	(DEFAULT, 'Alex', 'ADM', 'M', '111.111.111-11', '2500.00'),
    (DEFAULT, 'Cristina', 'JUR', 'F', '222.222.222-22', '9000.00'),
    (DEFAULT, 'Lopes', 'ENG', 'M', '333.333.333-33', '6500.00'),
    (DEFAULT, 'Angel', 'VENDAS', 'Outros','444.444.444-44', '1500.00');
    
select * from funcionarios;
    
select * from funcionarios where salario > 2000.00;
select * from funcionarios where salario < 2000.00;

UPDATE funcionarios SET salario = '2500.00' where nomeFuncionario = 'Angel';

select * from funcionarios;


#drop table funcionarios; #(limpar a tabela)
    
 
    
    