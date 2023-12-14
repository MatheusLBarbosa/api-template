package com.br.apitemplate.dto.callback;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CallbackRequest {
    private String numeroPedido;
    private String numeroOrdemExterno;
    private String chaveNFE;
    private String numeroNota;
    private LocalDateTime dataEmissao;
    private String pdf;
    private String status;
}
