package com.mineiro.personapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)     //campo obrigatorio
    private String primeiroNome;

    @Column(nullable = false)
    private String ultimoNome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> telefones = new ArrayList<>();

    /*--------------- Exemplo JSON:
  {
        "primeiroNome": "Rodrigo",
        "ultimoNome": "Volpe",
        "cpf": "234.567.890-33",
        "dataNascimento": "1967-11-03",
        "telefones": [
             {
                 "tipo": "CELULAR",
                 "numero": "(021) 99218-9693"
              }
        ]
    }*/
}
