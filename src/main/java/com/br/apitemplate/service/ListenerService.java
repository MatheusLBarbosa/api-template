package com.br.apitemplate.service;

import com.br.apitemplate.dto.PedidoDTO;
import com.br.apitemplate.dto.response.TributoResponse;
import com.br.apitemplate.client.ParceirosClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ListenerService {

    private final ParceirosClient client;

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consumeQueue(PedidoDTO message) {
        log.info(String.format("Mensagem recebida -> %s", message));


        message.getItens().stream().forEach(sku -> {
            try{
                TributoResponse tributoResponse = client.getMatrizTributaria(sku.getSku());
                //Enviar info das vendas para o endpoint da sefaz
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
