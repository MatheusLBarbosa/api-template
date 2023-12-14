package com.br.apitemplate.service;

import com.br.apitemplate.dto.sefaz.SefazRequest;
import com.br.apitemplate.dto.sefaz.SefazResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Slf4j
@Service
public class SefazService {

    public SefazResponse authorize(SefazRequest request){
        log.info("Sefazrequest: {}", request);
        return new SefazResponse("43210392754738001134550040000159551330237069", "0237069",
                LocalDateTime.now(), "NDMyMTAzOTI3NTQ3MzgwMDExMzQ1NTAwNDAwMDAxNTk1NTEzMzAyMzcwNjk=");
    }
}
