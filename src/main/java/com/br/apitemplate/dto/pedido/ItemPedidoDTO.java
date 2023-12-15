package com.br.apitemplate.dto.pedido;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ItemPedidoDTO implements Serializable {
    private Integer sku;
    private Long quantidade;
    private double valor;
}
