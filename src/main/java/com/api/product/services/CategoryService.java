package com.api.product.services;

import com.api.product.dto.CategoryDTO;
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
