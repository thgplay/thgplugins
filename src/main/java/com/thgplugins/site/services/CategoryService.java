package com.thgplugins.site.services;

import com.thgplugins.site.domain.Category;
import com.thgplugins.site.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category search(Integer id){
        Optional<Category> category = repository.findById(id);
        return category.orElse(null);
    }

}
