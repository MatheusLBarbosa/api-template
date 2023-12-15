package com.br.apitemplate.service;

import com.br.apitemplate.config.RabbitMqPublisher;
import com.br.apitemplate.dto.pedido.PedidoDTO;
import com.br.apitemplate.dto.pedido.AutorizacaoVendaResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class AutorizaVendaService {

    private final RabbitMqPublisher publisher;

    public AutorizacaoVendaResponse createOrder(PedidoDTO request) {
        log.info("c=SaleService, m=createOrder: processing order creation...");
        publisher.sendMessage(request);
        return new AutorizacaoVendaResponse("PROCESSING", LocalDateTime.now());
    }
}
