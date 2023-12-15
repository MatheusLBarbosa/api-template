package com.br.apitemplate.dto.tributo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TributoResponse {
    private Integer sku;
    private Double valorIcms;
    private Double valorPis;
    private Double valorDifaul;
    private Double  valorFcpIcms;
}
