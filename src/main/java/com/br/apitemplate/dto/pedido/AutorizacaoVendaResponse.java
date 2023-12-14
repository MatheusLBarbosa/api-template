package com.br.apitemplate.dto.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AutorizacaoVendaResponse {
    private String status;
    private LocalDateTime dataResposta;
}
