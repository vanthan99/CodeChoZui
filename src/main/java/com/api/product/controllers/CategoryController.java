package com.api.product.controllers;

import com.api.product.services.dto.CategoryDTO;
import com.api.product.services.handle.CategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    /*
    * Tìm Category theo ID
    * */
    @ApiOperation(
            value = "Tìm kiếm Category theo Id",
            httpMethod = "GET"
    )
    @GetMapping(value = "/{id}")
    public CategoryDTO findCategoryById(@PathVariable("id") Long id){
        return categoryService.findById(id);
    }

    /*
    * Trả về danh sách Category
    * */
    @ApiOperation(
            value = "Tìm kiếm tất cả Category",
            httpMethod = "GET"
    )
    @GetMapping
    public List<CategoryDTO> findAllCategory(){
        return categoryService.findAll();
    }

    // thêm mới Category
    @ApiOperation(
            value = "Thêm mới Category",
            httpMethod = "POST"
    )
    @PostMapping
    public CategoryDTO saveCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.save(categoryDTO);
    }

    // Chỉnh sửa Category
    @ApiOperation(
            value = "Chỉnh sửa Category",
            httpMethod = "PUT"
    )
    @PutMapping("/{id}")
    public CategoryDTO updateCategory(
            @PathVariable("id") Long id,
            @RequestBody CategoryDTO categoryDTO
    ){
        return categoryService.update(id,categoryDTO);
    }
}
