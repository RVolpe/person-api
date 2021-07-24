package com.mineiro.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

    CASA("Casa"),
    CELULAR("Celular"),
    COMERCIAL("Comercial");

    private String descricao;
}
