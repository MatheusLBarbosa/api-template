package com.br.apitemplate.dto.tributo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TributoResponse {
    private int sku;
    private int valorIcms;
    private int valorPis;
    private int valorDifaul;
    private int  valorFcpIcms;
}
