package com.thgplugins.site.domain;

import com.thgplugins.site.domain.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private Integer status;

    @OneToOne
    @JoinColumn(name = "order_id")
    @MapsId
    private Order order;

    public Payment() {}

    public Payment(Integer id, PaymentStatus status, Order order) {
        this.id = id;
        this.status = status.getId();
        this.order = order;
    }

    public PaymentStatus getStatus() {
        return PaymentStatus.toEnum(this.id);
    }

    public void setStatus(PaymentStatus status) {
        this.status = status.getId();
    }
}
