CREATE TABLE Comic (
	   id int not null auto_increment,
	   comic_id int not null Unique,
	   titulo VARCHAR(200),
       preco double,
       isbn varchar(17),
       descricao varchar(1000),
       
       primary key(id)
);