package com.api.product.services;

import com.api.product.entities.Category;
import com.api.product.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryService  {
    @Autowired
    private CategoryRepository repo;
    public List<Category> findAll(){
        return repo.findAll();
    }

    public Category findById(Long id){
        return repo.getOne(id);
    }

    public Category save(Category category){
        return repo.save(category);
    }
}
