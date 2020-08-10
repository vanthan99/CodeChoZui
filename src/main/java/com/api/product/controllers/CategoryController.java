package com.api.product.controllers;

import com.api.product.dto.CategoryDTO;
import com.api.product.entities.Category;
import com.api.product.mapper.impl.CategoryMapper;
import com.api.product.services.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryMapper mapper;

    @GetMapping
    @ApiOperation(
            value = "Trả về danh sách loại hàng"
    )
    public List<CategoryDTO> listCategory(){
        return mapper.toCategoryDtoList(categoryService.findAll());
    }

    @PostMapping
    @ApiOperation(
            value = "Thêm mới danh mục"
    )
    public CategoryDTO save(@RequestBody CategoryDTO dto){
        Category category = mapper.toCategory(dto);
        return mapper.toCategoryDto(categoryService.save(category));
    }

    @GetMapping("/{id}")
    @ApiOperation(
            value = "Tìm kiếm danh mục dựa vào ID"
    )
    public CategoryDTO findById(@PathVariable(name = "id") Long id){
        Category category = categoryService.findById(id);
        return mapper.toCategoryDto(category);
    }
    @ApiOperation(
            value = "Chỉnh sửa loại hàng"
    )
    @PutMapping("/{id}")
    public CategoryDTO update(@PathVariable(name = "id") Long id, @RequestBody CategoryDTO dto){
        Category category = mapper.toCategory(dto);
        category.setId(id);
        return mapper.toCategoryDto(categoryService.save(category));
    }
}
