package com.br.apitemplate.client;

import com.br.apitemplate.dto.response.TributoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "tributo", url = "http://localhost:8080/api/tributo")
public interface TributoClient {
    @GetMapping
    TributoResponse getMatrizTributaria(@RequestParam int sku);
}
