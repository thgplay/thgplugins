package com.thgplugins.site.domain;

import com.thgplugins.site.domain.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PaymentWithBoleto extends Payment{
    private static final long serialVersionUID = 1L;

    private Date due;
    private Date date;

    public PaymentWithBoleto() {
    }

    public PaymentWithBoleto(Integer id, PaymentStatus status, Order order, Date due, Date date) {
        super(id, status, order);
        this.due = due;
        this.date = date;
    }
}
