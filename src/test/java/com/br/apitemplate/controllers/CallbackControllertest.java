package com.br.apitemplate.controllers;

import com.br.apitemplate.dto.callback.CallbackRequest;
import com.br.apitemplate.dto.callback.CallbackResponse;
import com.br.apitemplate.service.CallbackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class CallbackControllertest {

    @Mock
    private CallbackService service;

    @InjectMocks
    private CallbackController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void authorizeSaleWithValidRequest() {
        CallbackRequest request = new CallbackRequest();
        CallbackResponse mockResponse = new CallbackResponse();

        when(service.sendToChannel(request)).thenReturn(mockResponse);

        ResponseEntity<CallbackResponse> responseEntity = controller.authorizeSale(request);

        verify(service, times(1)).sendToChannel(request);
        verifyNoMoreInteractions(service);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(mockResponse, responseEntity.getBody());
    }

    @Test
    void authorizeSaleWithInvalidRequest() {
        ResponseEntity<CallbackResponse> responseEntity = controller.authorizeSale(null);

        verifyNoInteractions(service);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }
}
