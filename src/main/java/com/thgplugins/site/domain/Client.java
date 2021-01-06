package com.thgplugins.site.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.thgplugins.site.domain.enums.ClientType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;

    @Column(name = "cpf_or_cnpj")
    private String cpfOrCnpj;

    @Column(name = "client_type")
    private Integer clientType;


    @JsonManagedReference
    @OneToMany(mappedBy = "client")
    private List<Address> addresses = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "phones")
    private Set<String> phones = new HashSet<>();

    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    public Client(){}

    public Client(Integer id, String nome, String email, String cpfOrCnpj, ClientType clientType) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOrCnpj = cpfOrCnpj;
        this.clientType = clientType.getId();
    }

    public ClientType getClientType() {
        return ClientType.toEnum(this.clientType);
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType.getId();
    }
}
