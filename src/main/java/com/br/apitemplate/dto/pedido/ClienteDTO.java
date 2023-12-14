package com.br.apitemplate.dto.pedido;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ClienteDTO implements Serializable {
    String id;
    String nome;
    String documento;
    String tipoDocumento;
    String tipoPessoa;
    String endereco;
    String numeroEndereco;
    String complementoEndereco;
    String bairro;
    String cidade;
    String estado;
    String pais;
    String cep;
    String codigoIbge;
    String telefone;
    String email;
}
