package com.thgplugins.site.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum ClientType {

    FISICAL(1, "Física"),
    JURIDICAL(2, "Jurídica");

    private int id;
    private String name;

    public static ClientType toEnum(Integer id){
        if (id == null) return null;
        return Arrays.stream(ClientType.values())
                .filter(clientType -> id.equals(clientType.getId())).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Id inválido: " + id));
    }

}
