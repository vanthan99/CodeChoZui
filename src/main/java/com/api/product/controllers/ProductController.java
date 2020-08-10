package com.api.product.controllers;

import com.api.product.dto.ProductDTO;
import com.api.product.entities.Product;
import com.api.product.mapper.impl.ProductMapper;
import com.api.product.services.CategoryService;
import com.api.product.services.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CategoryService categoryService;

    /*
    * lay danh sach san pham.
    * neu trong url co truyen vao tham so la catId thi
    * tra ve danh sach cua san pham dua vao ma category
    *
    * */
    @GetMapping
    @ApiOperation(value = "Trả về danh sách sản phẩm")
    public List<ProductDTO> listProduct(
            @ApiParam(value = "Id của category cần lấy danh sách sản phẩm")
            @RequestParam(value = "catId",required = false) Long catId){
        if (catId == null)
            return productMapper.toProductDtoList(productService.findAll());
        return productMapper.toProductDtoList(categoryService.findById(catId).getProducts());
    }

    /*
    * tra ve product dto
    * */

    @GetMapping(value = "/{id}")
    @ApiOperation(
            value = "Tìm kiếm sản phẩm dựa vào ID"
    )
    public ProductDTO findById(@PathVariable(name = "id") Long id){
        Product product = productService.findById(id);
        return productMapper.toProductDto(product);
    }
    /*
    * input: ProductDTO
    * chuc nang:  luu san pham
    * output: ProductDTO
    * */

    @PostMapping
    @ApiOperation(
            value = "Thêm mới sản phẩm"
    )
    public ProductDTO save(@RequestBody ProductDTO dto){
        Product product = productMapper.toProduct(dto);
        return productMapper.toProductDto(productService.save(product));
    }

    /*
     * input: ProductDTO, id on URL
     * chuc nang:  chinh sua san pham
     * output: ProductDTO
     * */
    @PutMapping(value = "/{id}")
    @ApiOperation(
            value = "Chỉnh sửa sản phẩm"
    )
    public ProductDTO update(@PathVariable(name = "id") Long id,
                             @RequestBody ProductDTO dto){
        Product product = productMapper.toProduct(dto);
        product.setId(id);
        return productMapper.toProductDto(productService.save(product));
    }
}
