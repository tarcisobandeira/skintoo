CREATE DATABASE IF NOT EXISTS SkinToo;
USE SkinToo;

DROP TABLE IF EXISTS Usuario;

CREATE TABLE Usuario(
	id 			INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nome		VARCHAR(50),
	sobrenome	VARCHAR(100),
	email		VARCHAR(50),
	senha		VARCHAR(50),
	prioridade	INT,
	ativo		INT
);

DROP TABLE IF EXISTS Informacoes;

CREATE TABLE Informacoes(
	id 			INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	id_usuario	INT,
	cpf			INT,
	telefone	VARCHAR(15),
	estado		VARCHAR(50),
	cidade		VARCHAR(50),
	rua			VARCHAR(50),
	numero_casa	INT,
	complemento	VARCHAR(50),
	referencia	VARCHAR(100),
	cep			INT,
	cadastrado	INT,
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id)
);

DROP TABLE IF EXISTS Produto;

CREATE TABLE Produto(
	id 			INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nome		VARCHAR(100),
	quantidade	INT
);