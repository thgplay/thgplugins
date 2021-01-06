package com.thgplugins.site;

import com.thgplugins.site.domain.*;
import com.thgplugins.site.domain.enums.ClientType;
import com.thgplugins.site.domain.enums.PaymentStatus;
import com.thgplugins.site.repositories.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public static void main(String[] args) {
        SpringApplication.run(SiteApplication.class, args);

    }

    @SneakyThrows
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
//
        Client cli2 = new Client(null, "Ana Luisa", "analuisa@gmail.com", "111.059.358-08", ClientType.FISICAL);
        cli2.getPhones().add("34 95812-8611");

        Address add3 = new Address(null, cli2, "Rua Monan Ribeiro", "909", "Apt 603, Bloco 3", "Alto Umuarama", city1, "38412-068");
        cli2.getAddresses().add(add3);


        Client cli3 = new Client(null, "Liliane Gonçalves", "liliane@gmail.com", "059.887.669-02", ClientType.JURIDICAL);


        clientRepository.saveAll(Arrays.asList(cli1, cli2, cli3));

        addressRepository.saveAll(Arrays.asList(add1, add2, add3));


        SimpleDateFormat sdf = new SimpleDateFormat("dd//MM/yyyy HH:mm");
        Order order1 = new Order(null, new Date(), cli1, add1);
        Order order2 = new Order(null, new Date(), cli2, add3);

        Payment payment1 = new PaymentWithCard(null, PaymentStatus.PAID, order1, 6);
        order1.setPayment(payment1);

        Payment payment2 = new PaymentWithBoleto(null, PaymentStatus.PENDING, order2, new Date(), null);
        order2.setPayment(payment2);

        cli1.getOrders().add(order1);
        cli2.getOrders().add(order2);

        orderRepository.saveAll(Arrays.asList(order1, order2));
        paymentRepository.saveAll(Arrays.asList(payment1, payment2));

    }
}
