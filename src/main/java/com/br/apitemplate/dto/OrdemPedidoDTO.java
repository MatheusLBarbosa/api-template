package com.br.apitemplate.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class OrdemPedidoDTO implements Serializable {
    String numeroPedido;
    String numeroOrdemExterno;
    String dataAutorizacao;
}
