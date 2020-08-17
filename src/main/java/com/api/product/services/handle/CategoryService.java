package com.api.product.services.handle;

import com.api.product.entities.Category;
import com.api.product.services.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    // find category by id
    CategoryDTO findById(Long id);

    // Find all category
    List<CategoryDTO> findAll();

    // save category
    CategoryDTO save(CategoryDTO categoryDTO);

    // update Category
    CategoryDTO update(Long id, CategoryDTO categoryDTO);
}
