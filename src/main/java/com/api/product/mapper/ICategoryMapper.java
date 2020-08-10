package com.api.product.mapper;

import com.api.product.dto.CategoryDTO;
import com.api.product.entities.Category;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ICategoryMapper {
    CategoryDTO toCategoryDto(Category category);
    List<CategoryDTO> toCategoryDtoList(List<Category> categoryList);
    Category toCategory(CategoryDTO categoryDTO);
}
