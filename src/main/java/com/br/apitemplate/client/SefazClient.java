package com.br.apitemplate.client;

import com.br.apitemplate.dto.sefaz.SefazRequest;
import com.br.apitemplate.dto.sefaz.SefazResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "sefaz", url = "http://localhost:8080/api/authorize")
public interface SefazClient {
    @PostMapping
    SefazResponse authorize(@RequestBody SefazRequest request);
}
