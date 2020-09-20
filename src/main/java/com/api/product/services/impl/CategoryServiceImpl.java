package com.api.product.services.impl;

import com.api.product.dto.CategoryDTO;
import com.api.product.entities.Category;
import com.api.product.repositories.CategoryRepository;
import com.api.product.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository repository;

    @Autowired
    public void setRepository(CategoryRepository repository) {
        this.repository = repository;
    }


    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public Page<Category> findAll(int limit, int page) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        return repository.findAll(pageable);
    }

    @Override
    public Category save(Category category) {
        return repository.save(category);
    }

    @Override
    public Category update(Long id, Category category) {
        category.setId(id);
        return repository.save(category);
    }


    //    @PostConstruct
//    public void initData(){
//        for (int i = 1 ; i <= 10 ; i++){
//            Category category = new Category();
//            category.setName("Danh mục số "+i);
//            categoryRepository.save(category);
//        }
//    }


}
