package com.thgplugins.site;

import com.thgplugins.site.domain.*;
import com.thgplugins.site.domain.enums.ClientType;
import com.thgplugins.site.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SiteApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    public static void main(String[] args) {
        SpringApplication.run(SiteApplication.class, args);

    }

    @Override
    public void run(String... args) {

        State state1 = new State(null, "Minas Gerais");
        State state2 = new State(null, "São Paulo");

        City city1 = new City(null, "Uberlândia", state1);
        City city2 = new City(null, "Uberaba", state1);
        City city3 = new City(null, "Marília", state2);

        state1.getCities().addAll(Arrays.asList(city1, city2));
        state2.getCities().add(city3);

        stateRepository.saveAll(Arrays.asList(state1, state2));
        cityRepository.saveAll(Arrays.asList(city1, city2, city3));

        Client cli1 = new Client(null, "Gabriel", "gabriel@gmail.com", "060.932.206-02", ClientType.FISICAL);
        cli1.getPhones().addAll(Arrays.asList("34 99643-1496", "34 98805-6047"));

        Address add1 = new Address(null, cli1, "Rua das Rosas", "295","","Cidade Jardim", city1, "38412-172");
        Address add2 = new Address(null, cli1, "Rua Cabral", "302","","Tubalina", city1, "38412-082");

        cli1.getAddresses().addAll(Arrays.asList(add1,add2));

        Client cli2 = new Client(null, "Ana Luisa", "analuisa@gmail.com", "111.059.358-08", ClientType.FISICAL);
        cli1.getPhones().add("34 95812-8611");

        Address add3 = new Address(null, cli2, "Rua Monan Ribeiro", "909", "Apt 603, Bloco 3", "Alto Umuarama", city1, "38412-068");
        cli2.getAddresses().add(add3);


        Client cli3 = new Client(null, "Liliane Gonçalves", "liliane@gmail.com", "059.887.669-02", ClientType.JURIDICAL);


        clientRepository.saveAll(Arrays.asList(cli1, cli2, cli3));

        addressRepository.saveAll(Arrays.asList(add1, add2, add3));

    }
}
