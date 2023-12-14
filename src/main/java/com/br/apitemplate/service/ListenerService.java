package com.br.apitemplate.service;

import com.br.apitemplate.client.SefazClient;
import com.br.apitemplate.client.TributoClient;
import com.br.apitemplate.dto.pedido.PedidoDTO;
import com.br.apitemplate.dto.sefaz.SefazRequest;
import com.br.apitemplate.dto.sefaz.SefazResponse;
import com.br.apitemplate.dto.tributo.TributoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Service
@RequiredArgsConstructor
public class ListenerService {

    private final TributoClient tributoClient;
    private final SefazClient sefazClient;

    private final CallbackService callbackService;
    private final EcommerceService ecommerceService;

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consumeQueue(PedidoDTO message) {
        log.info(String.format("Mensagem recebida -> %s", message));

        AtomicReference<SefazResponse> sefazResponse = new AtomicReference<>();
        message.getItens().stream().forEach(sku -> {
            try{
                TributoResponse tributoResponse = tributoClient.getMatrizTributaria(sku.getSku());
                sefazResponse.set(sefazClient.authorize(new SefazRequest(message.getOrdemPedido(), message.getCliente(), message.getItens(), tributoResponse)));
                callbackService.invokeCallback(sefazResponse.get(), message.getOrdemPedido());

            } catch (Exception e) {

                throw new RuntimeException(e);
            }
        });



    }
}
