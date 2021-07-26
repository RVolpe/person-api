package com.mineiro.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty
    @Size(min=2, max=100)
    private String primeiroNome;

    @NotEmpty
    @Size(min=2, max=100)
    private String ultimoNome;

    @NotEmpty
    @CPF
    private String cpf;

    @NotEmpty
    private String dataNascimento;

    @Valid
    @NotEmpty
    private List<PhoneDTO> telefones;
}
