CREATE SCHEMA ECOMMERCE;

CREATE TABLE ECOMMERCE.VENDA
(
    id                   NUMBER(38, 0) AUTO_INCREMENT PRIMARY KEY,
    canal                VARCHAR2(100) NOT NULL,
    codigo_empresa       INTEGER       NOT NULL,
    codigo_loja          INTEGER       NOT NULL,
    numero_pdv           INTEGER       NOT NULL,
    numero_pedido        VARCHAR2(38)  NOT NULL,
    numero_ordem_externo VARCHAR2(38)  NOT NULL,
    valor_total          NUMBER(38, 2) NOT NULL,
    qtd_item             NUMBER(38, 0) NOT NULL,
    venda_request        CLOB          NOT NULL,
    data_atualizacao     TIMESTAMP     NOT NULL,
    data_requisicao      TIMESTAMP     NOT NULL,
    chave_nfe            VARCHAR2(44),
    numero_nota          NUMBER(38, 0),
    data_emissao         TIMESTAMP,
    pdf                  CLOB,
    situacao             VARCHAR2(100) NOT NULL,
    motivo               VARCHAR2(255)
);
