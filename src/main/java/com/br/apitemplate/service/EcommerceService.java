package com.br.apitemplate.service;

import com.br.apitemplate.dto.ecommerce.VendaDTO;
import com.br.apitemplate.dto.pedido.ItemPedidoDTO;
import com.br.apitemplate.dto.pedido.PedidoDTO;
import com.br.apitemplate.dto.sefaz.SefazResponse;
import com.br.apitemplate.entity.Venda;
import com.br.apitemplate.repository.VendaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Service
@RequiredArgsConstructor
public class EcommerceService {
    private final VendaRepository repository;



    public void save(VendaDTO vendaDTO){
        log.info("Venda {} recebida para persistência...", vendaDTO.getNumeroPedido());
        try {
            Venda entity = new Venda();
            BeanUtils.copyProperties(vendaDTO, entity);
            repository.save(entity);
            log.info("Venda {} salva com sucesso...", vendaDTO.getNumeroPedido());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void invokePersistence(ItemPedidoDTO itemPedidoDTO, PedidoDTO pedidoDTO, AtomicReference<SefazResponse> sefazResponse, String situacao, String motivo){
        save(mapper(itemPedidoDTO, pedidoDTO, sefazResponse, situacao, motivo));
    }

    private VendaDTO mapper(ItemPedidoDTO itemPedidoDTO, PedidoDTO pedidoDTO, AtomicReference<SefazResponse> sefazResponse, String situacao, String motivo){
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
                Long.valueOf(sefazResponse.get().getInvoiceNumber()),
                sefazResponse.get().getIssuanceDate(),
                sefazResponse.get().getInvoice(),
                situacao,
                motivo
        );
    }

}
