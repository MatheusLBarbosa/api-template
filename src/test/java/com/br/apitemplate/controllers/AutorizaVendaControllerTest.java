package com.br.apitemplate.controllers;

import com.br.apitemplate.dto.pedido.AutorizacaoVendaResponse;
import com.br.apitemplate.dto.pedido.PedidoDTO;
import com.br.apitemplate.service.AutorizaVendaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

public class AutorizaVendaControllerTest {

    @Mock
    private AutorizaVendaService service;

    @InjectMocks
    private AutorizaVendaController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void authorizeSaleWithValidRequest() {
        PedidoDTO request = new PedidoDTO();
        AutorizacaoVendaResponse mockResponse = new AutorizacaoVendaResponse();

        when(service.createOrder(request)).thenReturn(mockResponse);

        ResponseEntity<AutorizacaoVendaResponse> responseEntity = controller.authorizeSale(request);

        verify(service, times(1)).createOrder(request);
        verifyNoMoreInteractions(service);

        Assertions.assertAll(
                () -> Assertions.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode()),
                () -> Assertions.assertEquals(mockResponse, responseEntity.getBody())
        );
    }

    @Test
    void authorizeSaleWithNullRequest() {
        ResponseEntity<AutorizacaoVendaResponse> responseEntity = controller.authorizeSale(null);

        verifyNoInteractions(service);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }
}
