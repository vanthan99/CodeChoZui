package com.api.product.services;

import com.api.product.dto.CategoryDTO;
import com.api.product.entities.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    // find category by id
    Category findById(Long id);

    // Find all category
    Page<Category> findAll(int limit, int page);

    // save category
    Category save(Category category);

    // update Category
    Category update(Long id, Category category);
}
