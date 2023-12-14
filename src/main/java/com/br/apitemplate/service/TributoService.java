package com.br.apitemplate.service;

import com.br.apitemplate.dto.response.TributoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TributoService {

    public TributoResponse getMatrizTributaria(int sku){
        log.info("Buscando matriz tributária do sku: {}", sku);
        return new TributoResponse(sku, 38, 12, 9, 58);
    }
}
