package com.thgplugins.site.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum PaymentStatus {

    PAID(1, "Quitado"),PENDING(1, "Pendente"),CANCELLED(3, "Cancelado");

    private int id;
    private String status;

    public static PaymentStatus toEnum(Integer id){
        if (id == null) return null;
        return Arrays.stream(PaymentStatus.values())
                .filter(clientType -> id.equals(clientType.getId())).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Id inválido: " + id));
    }

}
