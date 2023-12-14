package com.br.apitemplate.dto.sefaz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SefazResponse implements Serializable {
    private String nfeKey;
    private String invoiceNumber;
    private LocalDateTime issuanceDate;
    private String invoice;
}
