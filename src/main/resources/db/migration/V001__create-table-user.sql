create table user (
	id bigint not null auto_increment,
    nome varchar(60) not null,
    email varchar(255) not null UNIQUE,
    cpf varchar(25) not null UNIQUE,
    nascimento date not null,
   
    primary key (id)
);
