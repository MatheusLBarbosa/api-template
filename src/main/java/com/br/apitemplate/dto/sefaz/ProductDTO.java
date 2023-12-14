package com.br.apitemplate.dto.sefaz;

import com.br.apitemplate.dto.tributo.TributoResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    private int sku;
    private int amount;
    private double value;
    private double icmsValue;
    private double pisValue;
    private double difaulValue;
    private double fcpIcmsValue;

    public ProductDTO(int sku, int amount, double value, TributoResponse tributoResponse){
        this.sku = sku;
        this.amount = amount;
        this.value = value;
        this.icmsValue = tributoResponse.getValorIcms();
        this.pisValue = tributoResponse.getValorPis();
        this.difaulValue = tributoResponse.getValorDifaul();
        this.fcpIcmsValue = tributoResponse.getValorFcpIcms();
    }
}
