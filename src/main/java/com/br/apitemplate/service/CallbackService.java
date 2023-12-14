package com.br.apitemplate.service;

import com.br.apitemplate.client.CallbackClient;
import com.br.apitemplate.dto.callback.CallbackRequest;
import com.br.apitemplate.dto.callback.CallbackResponse;
import com.br.apitemplate.dto.pedido.OrdemPedidoDTO;
import com.br.apitemplate.dto.sefaz.SefazResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CallbackService {

    private final CallbackClient callbackClient;

    public CallbackResponse sendToChannel(CallbackRequest request){
        log.info("Venda {} realizada com sucesso...", request.getNumeroPedido());
        return new CallbackResponse("Venda " + request.getNumeroPedido() + " realizada com sucesso...");
    }

    public CallbackResponse invokeCallback(SefazResponse sefazResponse, OrdemPedidoDTO ordemPedido){
        log.info("Iniciando fluxo de callback...");
        return callbackClient.sendCallback(convertToCallbackRequest(sefazResponse, ordemPedido));
    }

    private CallbackRequest convertToCallbackRequest(SefazResponse sefazResponse, OrdemPedidoDTO ordemPedido) {
        CallbackRequest request = new CallbackRequest();

        request.setNumeroPedido(ordemPedido.getNumeroPedido());
        request.setNumeroOrdemExterno(ordemPedido.getNumeroOrdemExterno());
        request.setChaveNFE(sefazResponse.getNfeKey());
        request.setNumeroNota(sefazResponse.getInvoiceNumber());
        request.setDataEmissao(sefazResponse.getIssuanceDate());
        request.setPdf(sefazResponse.getInvoice());
        request.setStatus("PROCESSADO");

        return request;
    }
}
