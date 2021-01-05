package com.thgplugins.site.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

    public City(){ }

}
