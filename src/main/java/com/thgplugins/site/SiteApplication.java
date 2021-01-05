package com.thgplugins.site;

import com.thgplugins.site.domain.Category;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class SiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiteApplication.class, args);

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("site-jpa");
//        EntityManager em = emf.createEntityManager();

    }

}
