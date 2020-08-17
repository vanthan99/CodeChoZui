package com.api.product.services.handle.impl;

import com.api.product.entities.Category;
import com.api.product.entities.Product;
import com.api.product.repositories.CategoryRepository;
import com.api.product.services.dto.CategoryDTO;
import com.api.product.services.handle.CategoryService;
import com.api.product.services.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Component
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

//    @PostConstruct
//    public void initData(){
//        for (int i = 1 ; i <= 7 ; i++){
//            Category category = new Category();
//            category.setName("Danh mục số "+i);
//            categoryRepository.save(category);
//        }
//    }

    @Override
    public CategoryDTO findById(Long id) {
        return categoryMapper.toDTO(categoryRepository.getOne(id));
    }

    @Override
    public List<CategoryDTO> findAll() {
        return categoryMapper.toDTOList(categoryRepository.findAll());
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toEntity(categoryDTO);
        categoryRepository.save(category);
        return categoryMapper.toDTO(category);
    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO categoryDTO) {
        Category category = categoryMapper.toEntity(categoryDTO);
        category.setId(id);
        categoryRepository.save(category);
        return categoryMapper.toDTO(category);
    }


}
