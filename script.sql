/*
Passeio Seguro
Lucca Raphael Pereira dos Santos - RM 99675
Charlene Aparecida Estevam Mendes Fialho - RM552252
Bianca Leticia Román Caldeira - RM552267
Caio Rocha Fernandes - RM99617
*/

-- Removendo as tabelas e suas restrições de chave estrangeira, se existirem
DROP TABLE bicicleta CASCADE CONSTRAINTS;
DROP TABLE segurado CASCADE CONSTRAINTS;
DROP TABLE midia CASCADE CONSTRAINTS;
DROP TABLE model_pre_def CASCADE CONSTRAINTS;
DROP TABLE vistoria CASCADE CONSTRAINTS;

-- Removendo a sequência
DROP SEQUENCE seq_id_segurado;

-- Criando a sequência
CREATE SEQUENCE seq_id_segurado
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

-- Criando a tabela 'bicicleta' com suas colunas
CREATE TABLE bicicleta (
    id_bicicleta            NUMBER(5) CONSTRAINT bicicleta_pk PRIMARY KEY,
    marca_bike              VARCHAR2(20 BYTE) NOT NULL, 
    modelo_bike             VARCHAR2(20 BYTE) NOT NULL, 
    modalidade_bike         VARCHAR2(20 BYTE) NOT NULL,
    quantidade_rodas        NUMBER(6) NOT NULL,
    estado_uso              VARCHAR2(15 BYTE) NOT NULL,
    ano_compra              NUMBER(4) NOT NULL,
    valor_mercado           NUMBER(10) NOT NULL,
    nota_fiscal             VARCHAR2(30 BYTE) NOT NULL,
    nmr_serie               VARCHAR2(30 BYTE) NOT NULL,
    vlr_gps                 NUMBER(10),
    vlr_ciclo_computador    NUMBER(10),
    vlr_velocimetro_digital NUMBER(10),
    id_bicicleta_eletrica   NUMBER(5),
    marca_bateria           VARCHAR2(10 BYTE),
    potencia_bateria        NUMBER(5),
    valor_bateria           NUMBER(5),
    marca_motor             VARCHAR2(15 BYTE),
    potencia_motor          NUMBER(5),
    valor_motor             NUMBER(10),
    seg_cpf                 char(11) NOT NULL, 
    model_pre_def_id_modelo NUMBER(5) NOT NULL
);


-- Criando a tabela 'segurado' com suas colunas 
CREATE TABLE segurado (
    cpf         char(11) CONSTRAINT segurado_pk PRIMARY KEY, 
    nome        VARCHAR2(50 BYTE) NOT NULL,
    email       VARCHAR2(50 BYTE) NOT NULL,
    senha       VARCHAR2(15 BYTE) NOT NULL,
    id_segurado number(5) DEFAULT seq_id_segurado.NEXTVAL NOT NULL,
    tel_segurado VARCHAR2(13 BYTE) NOT NULL,
    end_segurado VARCHAR2(30 BYTE) NOT NULL
);


-- Criando a tabela 'midia' com suas colunas
CREATE TABLE midia (
    id_midia             NUMBER(5) NOT NULL,
    tipo_midia           VARCHAR2(1 BYTE),
    img_bike             BLOB,
    data_midia           DATE,
    descricao            VARCHAR2(60 BYTE),
    vistoria_id_vistoria NUMBER(5) NOT NULL
);

-- Adicionando uma chave primária composta à tabela 'midia' usando as colunas 'id_midia' e 'vistoria_id_vistoria'
ALTER TABLE midia ADD CONSTRAINT midia_pk PRIMARY KEY ( id_midia, vistoria_id_vistoria );

-- Criando a tabela 'model_pre_def' com suas colunas
CREATE TABLE model_pre_def (
    id_modelo     NUMBER(5) CONSTRAINT model_pre_def_pk PRIMARY KEY,
    pre_marca_nm  VARCHAR2(20 BYTE) NOT NULL,
    pre_modelo_nm VARCHAR2(15 BYTE) NOT NULL
);


-- Criando a tabela 'vistoria' com suas colunas
CREATE TABLE vistoria (
    id_vistoria             NUMBER(5) CONSTRAINT vistoria_pk PRIMARY KEY,
    data_hora_vistoria      TIMESTAMP,
    status_vistoria         VARCHAR2(15 BYTE),
    seg_cpf                 char(11) NOT NULL, 
    bicicleta_id_bicicleta  NUMBER(5) NOT NULL,
    model_pre_def_id_modelo NUMBER(5) NOT NULL
);



-- Adicionando restrições de chave estrangeira às tabelas 'bicicleta,' 'midia,' , 'vistoria' e'segurado'
ALTER TABLE bicicleta
    ADD CONSTRAINT bicicleta_segurado_fk FOREIGN KEY ( seg_cpf ) 
        REFERENCES segurado ( cpf ); 

-- Adicionando restrições de chave estrangeira às tabelas 'bicicleta,' 'midia,' e 'vistoria'
ALTER TABLE vistoria
    ADD CONSTRAINT vistoria_segurado_fk FOREIGN KEY ( seg_cpf ) 
        REFERENCES segurado ( cpf ); 


ALTER TABLE bicicleta
    ADD CONSTRAINT bicicleta_model_pre_def_fk FOREIGN KEY ( model_pre_def_id_modelo )
        REFERENCES model_pre_def ( id_modelo );

ALTER TABLE midia
    ADD CONSTRAINT midia_vistoria_fk FOREIGN KEY ( vistoria_id_vistoria )
        REFERENCES vistoria ( id_vistoria );

ALTER TABLE vistoria
    ADD CONSTRAINT vistoria_bicicleta_fk FOREIGN KEY ( bicicleta_id_bicicleta )
        REFERENCES bicicleta ( id_bicicleta );

ALTER TABLE vistoria
    ADD CONSTRAINT vistoria_model_pre_def_fk FOREIGN KEY ( model_pre_def_id_modelo )
        REFERENCES model_pre_def ( id_modelo );
        
-- Remova a restrição de chave estrangeira que faz referência à coluna 'model_pre_def_id_modelo' na tabela 'vistoria'
ALTER TABLE vistoria
    DROP CONSTRAINT vistoria_model_pre_def_fk; 

-- Remova a coluna 'model_pre_def_id_modelo' da tabela 'vistoria'
ALTER TABLE vistoria
    DROP COLUMN model_pre_def_id_modelo;

