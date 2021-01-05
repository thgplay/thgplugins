package com.thgplugins.site;

import com.thgplugins.site.domain.Category;
import com.thgplugins.site.domain.City;
import com.thgplugins.site.domain.Product;
import com.thgplugins.site.domain.State;
import com.thgplugins.site.repositories.CategoryRepository;
import com.thgplugins.site.repositories.CityRepository;
import com.thgplugins.site.repositories.ProductRepository;
import com.thgplugins.site.repositories.StateRepository;
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

    }
}
