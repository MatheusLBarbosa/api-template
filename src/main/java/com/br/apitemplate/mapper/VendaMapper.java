package com.br.apitemplate.mapper;

import com.br.apitemplate.dto.ecommerce.VendaDTO;
import com.br.apitemplate.dto.pedido.ItemPedidoDTO;
import com.br.apitemplate.dto.pedido.PedidoDTO;
import com.br.apitemplate.dto.sefaz.SefazResponse;
import com.br.apitemplate.entity.Venda;
import org.hibernate.engine.jdbc.ClobProxy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class VendaMapper {

    public VendaDTO mapperToDTO(ItemPedidoDTO itemPedidoDTO, PedidoDTO pedidoDTO, AtomicReference<SefazResponse> sefazResponse, String situacao, String motivo){
        return new VendaDTO(
                pedidoDTO.getCanal(),
                Integer.valueOf(pedidoDTO.getEmpresa()),
                Integer.valueOf(pedidoDTO.getLoja()),
                Integer.valueOf(pedidoDTO.getPdv()),
                pedidoDTO.getOrdemPedido().getNumeroPedido(),
                pedidoDTO.getOrdemPedido().getNumeroOrdemExterno(),
                itemPedidoDTO.getQuantidade() * itemPedidoDTO.getValor(),
                itemPedidoDTO.getQuantidade(),
                pedidoDTO.toString(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                sefazResponse.get().getNfeKey(),
                Integer.valueOf(sefazResponse.get().getInvoiceNumber()),
                sefazResponse.get().getIssuanceDate(),
                sefazResponse.get().getInvoice(),
                situacao,
                motivo
        );
    }

    public static Venda dtoToEntity(VendaDTO vendaDTO) {
        return Venda.builder()
                .canal(vendaDTO.getCanal())
                .codigoEmpresa(vendaDTO.getCodigoEmpresa())
                .codigoLoja(vendaDTO.getCodigoLoja())
                .numeroPdv(vendaDTO.getNumeroPdv())
                .numeroPedido(vendaDTO.getNumeroPedido())
                .numeroOrdemExterno(vendaDTO.getNumeroOrdemExterno())
                .valorTotal(BigDecimal.valueOf(vendaDTO.getValorTotal()))
                .qtdItem(vendaDTO.getQtdItem())
                .vendaRequest(ClobProxy.generateProxy(vendaDTO.getVendaRequest()))
                .dataAtualizacao(vendaDTO.getDataAtualizacao())
                .dataEmissao(vendaDTO.getDataEmissao())
                .chaveNfe(vendaDTO.getChaveNfe())
                .numeroNota(vendaDTO.getNumeroNota())
                .dataRequisicao(vendaDTO.getDataRequisicao())
                .pdf(ClobProxy.generateProxy(vendaDTO.getPdf()))
                .situacao(vendaDTO.getSituacao())
                .motivo(vendaDTO.getMotivo())
                .build();
    }
}
