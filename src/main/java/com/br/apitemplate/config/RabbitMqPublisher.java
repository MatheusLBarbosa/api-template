package com.br.apitemplate.config;

import com.br.apitemplate.dto.pedido.PedidoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMqPublisher {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private RabbitTemplate rabbitTemplate;

    public RabbitMqPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(PedidoDTO message) {
        log.info(String.format("Mensagem enviada -> %s", message));
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}
