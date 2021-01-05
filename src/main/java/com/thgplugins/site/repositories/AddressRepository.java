package com.thgplugins.site.repositories;

import com.thgplugins.site.domain.Address;
import com.thgplugins.site.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
