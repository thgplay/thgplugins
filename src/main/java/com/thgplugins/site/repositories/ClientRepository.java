package com.thgplugins.site.repositories;

import com.thgplugins.site.domain.Category;
import com.thgplugins.site.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
