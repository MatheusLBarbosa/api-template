package com.br.apitemplate.controllers;

import com.br.apitemplate.dto.sefaz.SefazRequest;
import com.br.apitemplate.dto.sefaz.SefazResponse;
import com.br.apitemplate.service.SefazService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/authorize")
public class SefazController {

    private final SefazService service;

    @PostMapping
    public SefazResponse authorize(@RequestBody @Valid SefazRequest request) {
        return service.authorize(request);
    }
}
