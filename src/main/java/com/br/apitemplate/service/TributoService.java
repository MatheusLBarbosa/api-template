package com.br.apitemplate.service;

import com.br.apitemplate.dto.tributo.TributoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TributoService {

    public TributoResponse getMatrizTributaria(int sku){
        log.info("Buscando matriz tributária do sku: {}", sku);
        return new TributoResponse(sku, 38.0, 12.0, 9.0, 58.0);
    }
}
