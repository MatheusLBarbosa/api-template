package com.br.apitemplate.dto.sefaz;

import com.br.apitemplate.dto.pedido.ClienteDTO;
import com.br.apitemplate.dto.pedido.ItemPedidoDTO;
import com.br.apitemplate.dto.pedido.OrdemPedidoDTO;
import com.br.apitemplate.dto.tributo.TributoResponse;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SefazRequest {
    private String orderNumber;
    private String externalOrderNumber;
    private CustomerDTO customer;
    private List<ProductDTO> products;

    public SefazRequest (OrdemPedidoDTO ordemPedidoDTO, ClienteDTO clienteDTO, List<ItemPedidoDTO> itemPedidoDTOList, TributoResponse tributoResponse){
        this.orderNumber = ordemPedidoDTO.getNumeroPedido();
        this.externalOrderNumber = ordemPedidoDTO.getNumeroOrdemExterno();
        this.customer = new CustomerDTO(clienteDTO);
        this.products = convertList(itemPedidoDTOList, tributoResponse);
    }

    private List<ProductDTO> convertList(List<ItemPedidoDTO> itemPedidoDTOList, TributoResponse tributoResponse) {
        return itemPedidoDTOList.stream().map(itemPedidoDTO ->
                new ProductDTO(itemPedidoDTO.getSku(), itemPedidoDTO.getQuantidade(), itemPedidoDTO.getValor(), tributoResponse))
                .collect(Collectors.toList());
    }
}
