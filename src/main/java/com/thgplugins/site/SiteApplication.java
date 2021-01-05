package com.thgplugins.site;

import com.thgplugins.site.domain.Category;
import com.thgplugins.site.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;

@SpringBootApplication
public class SiteApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SiteApplication.class, args);

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("site-jpa");
//        EntityManager em = emf.createEntityManager();

    }

    @Override
    public void run(String... args) {

        Category cat1 = new Category(null, "Motorista");
        Category cat2 = new Category(null, "Empresario");
        Category cat3 = new Category(null, "Programador");

        repository.saveAll(Arrays.asList(cat1,cat2,cat3));

    }
}
