package com.br.apitemplate.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ItemPedidoDTO implements Serializable {
    int sku;
    int quantidade;
    int valor;
}
