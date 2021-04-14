CREATE DATABASE IF NOT EXISTS SkinToo;
USE SkinToo;

DROP TABLE IF EXISTS Usuario;

CREATE TABLE Usuario(
	id 			INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nome		VARCHAR(100),
	cpf			INT,
	login		VARCHAR(50),
	senha		VARCHAR(50),
	email		VARCHAR(50),
	telefone	VARCHAR(15),
	rua			VARCHAR(50),
	numero_casa	INT,
	complemento	VARCHAR(50),
	referencia	VARCHAR(100),
	cep			INT,
	ativo		INT
);

DROP TABLE IF EXISTS Produto;

CREATE TABLE Produto(
	id 			INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nome		VARCHAR(100),
	quantidade	INT
);