CREATE DATABASE IF NOT EXISTS SkinToo;
USE SkinToo;

DROP TABLE IF EXISTS

CREATE TABLE Usuario(
	id 			INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nome		VARCHAR(100),
	cpf			INT,
	login		VARCHAR(50),
	senha		VARCHAR(50),
	email		VARCHAR(50),
	telefone	VARCHAR(11),
	rua			VARCHAR(50),
	numero_casa	INT,
	referencia	VARCHAR(50),
	cep			INT
);