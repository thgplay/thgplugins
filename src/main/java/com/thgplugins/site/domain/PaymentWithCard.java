package com.thgplugins.site.domain;

import com.thgplugins.site.domain.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PaymentWithCard extends Payment{
    private static final long serialVersionUID = 1L;

    private Integer installments; // Número de Parcelas

    public PaymentWithCard() {
    }


    public PaymentWithCard(Integer id, PaymentStatus status, Order order, Integer installments) {
        super(id, status, order);
        this.installments = installments;
    }
}
