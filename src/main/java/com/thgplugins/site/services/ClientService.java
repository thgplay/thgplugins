package com.thgplugins.site.services;

import com.thgplugins.site.domain.Client;
import com.thgplugins.site.repositories.ClientRepository;
import com.thgplugins.site.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client search(Integer id){
        Optional<Client> client = repository.findById(id);
        return client.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Client.class.getName()));
    }

}
