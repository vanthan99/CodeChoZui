package com.api.product.mapper.impl;

import com.api.product.entities.Category;
import com.api.product.dto.CategoryDTO;
import com.api.product.mapper.CategoryMapper;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public CategoryDTO toDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }

    @Override
    public List<CategoryDTO> toDTOList(List<Category> categories) {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (Category item : categories){
            categoryDTOS.add(toDTO(item));
        }
        return categoryDTOS;
    }

    @Override
    public Category toEntity(CategoryDTO dto) {
        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        return category;
    }
}
