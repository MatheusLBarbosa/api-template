package com.br.apitemplate.dto.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorizacaoVendaResponse {
    private String status;
    private LocalDateTime dataResposta;
}
