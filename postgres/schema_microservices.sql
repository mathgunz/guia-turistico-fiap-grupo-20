--CLIENTE-FIAP

CREATE SCHEMA cliente_fiap AUTHORIZATION postgres;

CREATE TABLE cliente_fiap.endereco (
	id bigserial NOT NULL,
	bairro varchar(255) NULL,
	cep varchar(255) NULL,
	cidade varchar(255) NULL,
	endereco varchar(255) NULL,
	estado varchar(255) NULL,
	numero int4 NULL,
	CONSTRAINT endereco_pkey PRIMARY KEY (id)
);

CREATE TABLE cliente_fiap.cliente (
	id bigserial NOT NULL,
	cpf varchar(255) NULL,
	email varchar(255) NULL,
	nome varchar(255) NULL,
	telefone int8 NULL,
	endereco_id int8 NULL,
	CONSTRAINT cliente_pkey PRIMARY KEY (id)
);

ALTER TABLE cliente_fiap.cliente ADD CONSTRAINT fk64nr9yt889by5lufr1boo5i4s FOREIGN KEY (endereco_id) REFERENCES cliente_fiap.endereco(id);

-- GUIA-FIAP

CREATE SCHEMA guia_fiap AUTHORIZATION postgres;

CREATE TABLE guia_fiap.endereco (
	id bigserial NOT NULL,
	bairro varchar(255) NULL,
	cep varchar(255) NULL,
	cidade varchar(255) NULL,
	endereco varchar(255) NULL,
	estado varchar(255) NULL,
	numero int4 NULL,
	CONSTRAINT endereco_pkey PRIMARY KEY (id)
);

CREATE TABLE guia_fiap.guia (
	id bigserial NOT NULL,
	cpf varchar(255) NULL,
	email varchar(255) NULL,
	nome varchar(255) NULL,
	telefone int8 NULL,
	endereco_id int8 NULL,
	CONSTRAINT guia_pkey PRIMARY KEY (id),
	CONSTRAINT fk69lss9dbuw7d3rbmoaif7mv1e FOREIGN KEY (endereco_id) REFERENCES guia_fiap.endereco(id)
);

CREATE TABLE guia_fiap.atracao (
	id bigserial NOT NULL,
	descricao varchar(255) NULL,
	nome varchar(255) NULL,
	publico_alvo varchar(255) NULL,
	tipo varchar(255) NULL,
	valor varchar(255) NULL,
	endereco_id int8 NULL,
	guia_id int8 NOT NULL,
	CONSTRAINT atracao_pkey PRIMARY KEY (id),
	CONSTRAINT fk8huuy36spwwsi2o150pwtavqa FOREIGN KEY (endereco_id) REFERENCES guia_fiap.endereco(id),
	CONSTRAINT fk9h9rsso69260eyu5jolsop6my FOREIGN KEY (guia_id) REFERENCES guia_fiap.guia(id)
);


-- CONTROLE-GUIA-FIAP
CREATE SCHEMA controle_guia_fiap AUTHORIZATION postgres;

CREATE TABLE controle_guia_fiap.controle_guia_turistico (
	id bigserial NOT NULL,
	checkin date NULL,
	checkout date NULL,
	cliente_id int8 NULL,
	cliente_nome varchar(255) NULL,
	criacao date NULL,
	guia_id int8 NULL,
	guia_nome varchar(255) NULL,
	status varchar(255) NULL,
	CONSTRAINT controle_guia_turistico_pkey PRIMARY KEY (id)
);

CREATE TABLE controle_guia_fiap.roteiro (
	id bigserial NOT NULL,
	criacao timestamp NULL,
	descricao varchar(255) NULL,
	nome varchar(255) NULL,
	contratacao_id int8 NOT NULL,
	CONSTRAINT roteiro_pkey PRIMARY KEY (id),
	CONSTRAINT fke6ph3wipo9noqkvsrapwhdaru FOREIGN KEY (contratacao_id) REFERENCES controle_guia_fiap.controle_guia_turistico(id)
);

CREATE TABLE controle_guia_fiap.roteiro_atracao (
	id bigserial NOT NULL,
	atracao_id int8 NULL,
	nome varchar(255) NULL,
	roteiro_id int8 NULL,
	CONSTRAINT roteiro_atracao_pkey PRIMARY KEY (id),
	CONSTRAINT fk4tvk75o3pro48ykqdme5jsxk2 FOREIGN KEY (roteiro_id) REFERENCES controle_guia_fiap.roteiro(id)
);