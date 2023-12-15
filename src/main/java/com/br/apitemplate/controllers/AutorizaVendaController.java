package com.br.apitemplate.controllers;

import com.br.apitemplate.dto.pedido.PedidoDTO;
import com.br.apitemplate.dto.pedido.AutorizacaoVendaResponse;
import com.br.apitemplate.service.AutorizaVendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping(value = "/api/autorizar-venda")
@RequiredArgsConstructor
public class AutorizaVendaController {

    private final AutorizaVendaService service;
    @PostMapping
    public ResponseEntity<AutorizacaoVendaResponse> authorizeSale(@RequestBody @Valid PedidoDTO request) {
        log.info("AuthorizeSale: request recebido {}", request);
        if (Objects.nonNull(request)) {
            return new ResponseEntity<>(service.createOrder(request), HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
