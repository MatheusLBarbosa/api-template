package com.br.apitemplate.controllers;

import com.br.apitemplate.dto.sefaz.SefazRequest;
import com.br.apitemplate.dto.sefaz.SefazResponse;
import com.br.apitemplate.service.SefazService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class SefazControllerTest {

    @Mock
    private SefazService service;

    @InjectMocks
    private SefazController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void authorizeWithValidRequest() {
        SefazRequest request = new SefazRequest();
        SefazResponse mockResponse = new SefazResponse();

        when(service.authorize(request)).thenReturn(mockResponse);

        SefazResponse response = controller.authorize(request);

        verify(service, times(1)).authorize(request);
        verifyNoMoreInteractions(service);

        Assertions.assertEquals(mockResponse, response);
    }

}
