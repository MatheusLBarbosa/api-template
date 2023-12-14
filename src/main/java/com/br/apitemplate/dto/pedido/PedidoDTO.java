package com.br.apitemplate.dto.pedido;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class PedidoDTO implements Serializable {
    private String canal;
    private String empresa;
    private String loja;
    private String pdv;
    private OrdemPedidoDTO ordemPedido;
    private ClienteDTO cliente;
    private int totalItens;
    private int quantidadeItens;
    private List<ItemPedidoDTO> itens;
}
