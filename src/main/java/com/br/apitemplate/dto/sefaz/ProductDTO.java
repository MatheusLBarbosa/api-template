package com.br.apitemplate.dto.sefaz;

import com.br.apitemplate.dto.tributo.TributoResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    private Integer sku;
    private Integer amount;
    private Double value;
    private Double icmsValue;
    private Double pisValue;
    private Double difaulValue;
    private Double fcpIcmsValue;

    public ProductDTO(Integer sku, Integer amount, Double value, TributoResponse tributoResponse){
        this.sku = sku;
        this.amount = amount;
        this.value = value;
        this.icmsValue = tributoResponse.getValorIcms();
        this.pisValue = tributoResponse.getValorPis();
        this.difaulValue = tributoResponse.getValorDifaul();
        this.fcpIcmsValue = tributoResponse.getValorFcpIcms();
    }
}
