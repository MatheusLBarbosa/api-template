package com.br.apitemplate.controllers;

import com.br.apitemplate.dto.callback.CallbackRequest;
import com.br.apitemplate.dto.callback.CallbackResponse;
import com.br.apitemplate.dto.pedido.AutorizacaoVendaResponse;
import com.br.apitemplate.dto.pedido.PedidoDTO;
import com.br.apitemplate.service.CallbackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(value = "/api/callback-venda")
@RequiredArgsConstructor
public class CallbackController {

    private final CallbackService service;

    @PostMapping
    public ResponseEntity<CallbackResponse> authorizeSale(@RequestBody @Valid CallbackRequest request) {
        if (Objects.nonNull(request)) {
            return new ResponseEntity<>(service.sendToChannel(request), HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
