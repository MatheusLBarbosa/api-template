package com.br.apitemplate.service;

import com.br.apitemplate.client.SefazClient;
import com.br.apitemplate.dto.PedidoDTO;
import com.br.apitemplate.dto.response.TributoResponse;
import com.br.apitemplate.client.TributoClient;
import com.br.apitemplate.dto.sefaz.SefazRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ListenerService {

    private final TributoClient tributoClient;
    private final SefazClient sefazClient;

    private final SefazService sefazService;

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consumeQueue(PedidoDTO message) {
        log.info(String.format("Mensagem recebida -> %s", message));

        List<TributoResponse> tributoResponseList = new ArrayList<>();
        SefazRequest sefazRequest;
        message.getItens().stream().forEach(sku -> {
            try{
                TributoResponse tributoResponse = tributoClient.getMatrizTributaria(sku.getSku());
                sefazClient.authorize(new SefazRequest(message.getOrdemPedido(), message.getCliente(), message.getItens(), tributoResponse));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });



    }
}
