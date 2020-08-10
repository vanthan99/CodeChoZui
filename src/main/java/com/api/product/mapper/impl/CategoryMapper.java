package com.api.product.mapper.impl;

import com.api.product.dto.CategoryDTO;
import com.api.product.entities.Category;
import com.api.product.mapper.ICategoryMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper implements ICategoryMapper {
    @Override
    public CategoryDTO toCategoryDto(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }

    @Override
    public List<CategoryDTO> toCategoryDtoList(List<Category> categoryList) {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (Category category : categoryList){
            categoryDTOS.add(toCategoryDto(category));
        }
        return categoryDTOS;
    }

    @Override
    public Category toCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        return category;
    }
}
