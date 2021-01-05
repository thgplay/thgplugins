package com.thgplugins.site.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private String logradouro;
    private String number;
    private String complement;
    private String district;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    private String zipcode;

    public Address(){}

}
