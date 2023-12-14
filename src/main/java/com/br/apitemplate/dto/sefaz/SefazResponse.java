package com.br.apitemplate.dto.sefaz;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class SefazResponse {
    private String nfeKey;
    private String invoiceNumber;
    private LocalDateTime issuanceDate;
    private String invoice;
}
