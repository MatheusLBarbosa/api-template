package com.br.apitemplate.dto.sefaz;

import com.br.apitemplate.dto.ClienteDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDTO {
    private String id;
    private String name;
    private String document;
    private String documentType;
    private String personType;
    private String address;
    private String addressNumber;
    private String addressComplement;
    private String district;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String ibgeCode;
    private String phoneNumber;
    private String email;

    public CustomerDTO(ClienteDTO clienteDTO) {
        this.id = clienteDTO.getId();
        this.name = clienteDTO.getNome();
        this.document = clienteDTO.getDocumento();
        this.documentType = clienteDTO.getTipoDocumento();
        this.personType = clienteDTO.getTipoPessoa();
        this.address = clienteDTO.getEndereco();
        this.addressNumber = clienteDTO.getNumeroEndereco();
        this.addressComplement = clienteDTO.getComplementoEndereco();
        this.district = clienteDTO.getBairro();
        this.city = clienteDTO.getCidade();
        this.state = clienteDTO.getEstado();
        this.country = clienteDTO.getPais();
        this.zipCode = clienteDTO.getCep();
        this.ibgeCode = clienteDTO.getCodigoIbge();
        this.phoneNumber = clienteDTO.getTelefone();
        this.email = clienteDTO.getEmail();
    }
}
