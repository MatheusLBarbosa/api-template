package com.br.apitemplate.controllers;

import com.br.apitemplate.dto.tributo.TributoResponse;
import com.br.apitemplate.service.TributoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class TributoControllerTest {
    @Mock
    private TributoService service;

    @InjectMocks
    private TributoController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getTaxWithValidSku() {
        int sku = 123;
        TributoResponse mockResponse = new TributoResponse();

        when(service.getMatrizTributaria(sku)).thenReturn(mockResponse);

        TributoResponse response = controller.getTax(sku);

        verify(service, times(1)).getMatrizTributaria(sku);
        verifyNoMoreInteractions(service);

        Assertions.assertEquals(mockResponse, response);
    }
}
