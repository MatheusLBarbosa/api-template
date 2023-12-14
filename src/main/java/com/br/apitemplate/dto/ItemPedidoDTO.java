package com.br.apitemplate.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ItemPedidoDTO implements Serializable {
    private int sku;
    private int quantidade;
    private double valor;
}
