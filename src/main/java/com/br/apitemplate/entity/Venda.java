package com.br.apitemplate.entity;

import jakarta.persistence.*;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Clob;
import java.time.LocalDateTime;
@Entity
@ToString
@Table(name = "VENDA", schema = "ECOMMERCE")
public class Venda implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID", updatable = false, nullable = false, unique = true)
        private BigInteger id;
        @Column(name = "CANAL", nullable = false, length = 100)
        private String canal;
        @Column(name = "CODIGO_EMPRESA", nullable = false)
        private Integer codigoEmpresa;
        @Column(name = "CODIGO_LOJA", nullable = false)
        private Integer codigoLoja;
        @Column(name = "NUMERO_PDV", nullable = false)
        private Integer numeroPdv;
        @Column(name = "NUMERO_PEDIDO", nullable = false, length = 38)
        private String numeroPedido;
        @Column(name = "NUMERO_ORDEM_EXTERNO", nullable = false, length = 38)
        private String numeroOrdemExterno;
        @Column(name = "VALOR_TOTAL", nullable = false, precision = 38, scale = 2)
        private BigDecimal valorTotal;
        @Column(name = "QTD_ITEM", nullable = false, precision = 38)
        private BigDecimal qtdItem;
        @Column(name = "VENDA_REQUEST", nullable = false)
        private Clob vendaRequest;
        @Column(name = "DATA_ATUALIZACAO", nullable = false)
        private LocalDateTime dataAtualizacao;
        @Column(name = "DATA_REQUISICAO", nullable = false)
        private LocalDateTime dataRequisicao;
        @Column(name = "CHAVE_NFE", length = 44)
        private String chaveNfe;
        @Column(name = "NUMERO_NOTA", precision = 38)
        private BigDecimal numeroNota;
        @Column(name = "DATA_EMISSAO")
        private LocalDateTime dataEmissao;
        @Column(name = "PDF")
        private Clob pdf;
        @Column(name = "SITUACAO", nullable = false, length = 100)
        private String situacao;
        @Column(name = "MOTIVO", length = 255)
        private String motivo;
}
