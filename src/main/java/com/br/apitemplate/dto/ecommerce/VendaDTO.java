package com.br.apitemplate.dto.ecommerce;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class VendaDTO {
    private BigInteger id;
    private String canal;
    private Integer codigoEmpresa;
    private Integer codigoLoja;
    private Integer numeroPdv;
    private String numeroPedido;
    private String numeroOrdemExterno;
    private Double valorTotal;
    private Long qtdItem;
    private String vendaRequest;
    private LocalDateTime dataAtualizacao;
    private LocalDateTime dataRequisicao;
    private String chaveNfe;
    private Long numeroNota;
    private LocalDateTime dataEmissao;
    private String pdf;
    private String situacao;
    private String motivo;

    public VendaDTO(String canal, Integer codigoEmpresa, Integer codigoLoja, Integer numeroPdv, String numeroPedido, String numeroOrdemExterno, Double valorTotal, Long qtdItem, String vendaRequest, LocalDateTime dataAtualizacao, LocalDateTime dataRequisicao, String chaveNfe, Long numeroNota, LocalDateTime dataEmissao, String pdf, String situacao, String motivo) {
        this.canal = canal;
        this.codigoEmpresa = codigoEmpresa;
        this.codigoLoja = codigoLoja;
        this.numeroPdv = numeroPdv;
        this.numeroPedido = numeroPedido;
        this.numeroOrdemExterno = numeroOrdemExterno;
        this.valorTotal = valorTotal;
        this.qtdItem = qtdItem;
        this.vendaRequest = vendaRequest;
        this.dataAtualizacao = dataAtualizacao;
        this.dataRequisicao = dataRequisicao;
        this.chaveNfe = (chaveNfe != null) ? chaveNfe : null;
        this.numeroNota = (numeroNota != null) ? numeroNota : null;
        this.dataEmissao = (dataEmissao != null) ? dataEmissao : null;
        this.pdf = (pdf != null) ? pdf : null;
        this.situacao = situacao;
        this.motivo = (motivo != null) ? motivo : null;
    }
}
