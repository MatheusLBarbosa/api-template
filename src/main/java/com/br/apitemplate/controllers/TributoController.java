package com.br.apitemplate.controllers;

import com.br.apitemplate.dto.response.TributoResponse;
import com.br.apitemplate.service.TributoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/tributo")
public class TributoController {

    private final TributoService service;
    @GetMapping
    @ResponseBody
    public TributoResponse getTax(@RequestParam int sku){
        return service.getMatrizTributaria(sku);
    }
}
