package com.br.apitemplate.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class PedidoDTO implements Serializable {
    String canal;
    String empresa;
    String loja;
    int pdv;
    OrdemPedidoDTO ordemPedido;
    ClienteDTO cliente;
    int totalItens;
    int quantidadeItens;
    List<ItemPedidoDTO> itens;
}
