package com.br.apitemplate.service;

import com.br.apitemplate.dto.ecommerce.VendaDTO;
import com.br.apitemplate.dto.pedido.ItemPedidoDTO;
import com.br.apitemplate.dto.pedido.PedidoDTO;
import com.br.apitemplate.dto.sefaz.SefazResponse;
import com.br.apitemplate.entity.Venda;
import com.br.apitemplate.mapper.VendaMapper;
import com.br.apitemplate.repository.VendaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Service
@RequiredArgsConstructor
public class EcommerceService {
    private final VendaRepository repository;

    private final VendaMapper mapper;

    public void save(VendaDTO vendaDTO){
        log.info("Venda {} recebida para persistência...", vendaDTO.getNumeroPedido());
        try {
            Venda entity = mapper.dtoToEntity(vendaDTO);
            repository.save(entity);
            log.info("Venda {} salva com sucesso...", vendaDTO.getNumeroPedido());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void invokePersistence(ItemPedidoDTO itemPedidoDTO, PedidoDTO pedidoDTO, AtomicReference<SefazResponse> sefazResponse, String situacao, String motivo){
        save(mapper.mapperToDTO(itemPedidoDTO, pedidoDTO, sefazResponse, situacao, motivo));
    }

}
