package com.api.product.controllers;

import com.api.product.entities.Category;
import com.api.product.services.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /*
     * Tìm Category theo ID
     * */
    @ApiOperation(
            value = "Tìm kiếm Category theo Id",
            httpMethod = "GET"
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findCategoryById(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }

    /*
     * Trả về danh sách Category
     * */
    @ApiOperation(
            value = "Tìm kiếm tất cả Category",
            httpMethod = "GET"
    )
    @GetMapping
    public ResponseEntity<Page<Category>> findAllCategory(
            @RequestParam(value = "limit") Integer limit,
            @RequestParam(value = "page") Integer page
    ) {
        if (limit != null && page != null)
            return new ResponseEntity<>(categoryService.findAll(limit, page), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // thêm mới Category
    @ApiOperation(
            value = "Thêm mới Category",
            httpMethod = "POST"
    )
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        if (category != null)
            return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Chỉnh sửa Category
    @ApiOperation(
            value = "Chỉnh sửa Category",
            httpMethod = "PUT"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(
            @PathVariable("id") Long id,
            @RequestBody Category category
    ) {
        if (id == null || category == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(categoryService.update(id, category), HttpStatus.OK);
    }
}
