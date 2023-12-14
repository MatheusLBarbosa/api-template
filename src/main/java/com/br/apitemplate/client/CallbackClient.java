package com.br.apitemplate.client;

import com.br.apitemplate.dto.callback.CallbackRequest;
import com.br.apitemplate.dto.callback.CallbackResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "canal", url = "http://localhost:8080/api/callback-venda")
public interface CallbackClient {
    @PostMapping
    CallbackResponse sendCallback(@RequestBody CallbackRequest request);
}
