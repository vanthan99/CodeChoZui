package com.api.product.mapper;

import com.api.product.entities.Category;
import com.api.product.dto.CategoryDTO;
import java.util.List;

public interface CategoryMapper {
    CategoryDTO toDTO(Category category);
    List<CategoryDTO> toDTOList(List<Category> categories);
    Category toEntity(CategoryDTO dto);
}
