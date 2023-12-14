package com.br.apitemplate.dto.pedido;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class OrdemPedidoDTO implements Serializable {
    private String numeroPedido;
    private String numeroOrdemExterno;
    private String dataAutorizacao;
}
