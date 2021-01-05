package com.thgplugins.site;

import com.thgplugins.site.domain.Category;
import com.thgplugins.site.domain.Product;
import com.thgplugins.site.repositories.CategoryRepository;
import com.thgplugins.site.repositories.ProductRepository;
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

    public static void main(String[] args) {
        SpringApplication.run(SiteApplication.class, args);

    }

    @Override
    public void run(String... args) {

        Category cat1 = new Category(null, "Casa");
        Category cat2 = new Category(null, "Carro");

        Product p1 = new Product(null, "Perfume", 25.50);
        Product p2 = new Product(null, "Volante", 200.00);
        Product p3 = new Product(null, "Marcha", 850.00);

        cat1.getProducts().add(p1);
        cat2.getProducts().addAll(Arrays.asList(p1,p2,p3));

        p1.getCategories().addAll(Arrays.asList(cat1,cat2));
        p2.getCategories().add(cat2);
        p3.getCategories().add(cat2);



//        categoryRepository.saveAll(Arrays.asList(cat1,cat2));
//        productRepository.saveAll(Arrays.asList(p1,p2,p3));

    }
}
