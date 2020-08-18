package com.api.product.controllers;

import com.api.product.dto.ProductDTO;
import com.api.product.services.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    /*Tìm kiếm tất cả Product*/
    @GetMapping
    @ApiOperation(value = "Danh sách tất cả Product")
    public List<ProductDTO> findAllProduct(
            @ApiParam(value = "Id của Category")
            @RequestParam(value = "catId",required = false) Long catId,

            @ApiParam(value = "Id của Supplier")
            @RequestParam(value = "supId",required = false) Long supId
    ){
        // Trường hợp tìm kiếm theo category
        if (!(catId == null)){
            return productService.findAllProductByCategory(catId);
        }

        // Trường hợp tìm kiếm theo supplier
        else if (!(supId == null)){
            return productService.findAllProductBySupplier(supId);
        }

        // Trường hợp còn lại. Tìm kiếm tất cả products
        else return productService.findAllProduct();
    }

    /*Tìm kiếm tất cả Product đang hoạt động*/
    @GetMapping(value = "active")
    @ApiOperation(value = "Tìm kiếm tất cả product đang hoạt động")
    public List<ProductDTO> findAllProductIsActive(){
        return productService.findAllProductIsActive();
    }

    /*Tìm kiếm tất cả Product ngừng hoạt động*/
    @GetMapping(value = "notActive")
    @ApiOperation(value = "Tìm kiếm tất cả product không hoạt động")
    public List<ProductDTO> findAllProductIsNotActive(){
        return productService.findAllProductIsNotActive();
    }

    /*Tìm kiếm Product dựa vào Id*/
    @ApiOperation(value = "Tìm kiếm Product theo Id")
    @GetMapping("/{id}")
    public ProductDTO findProductById(@ApiParam(value = "Id của Product cần tìm") @PathVariable("id") Long id){
        return productService.findProductById(id);
    }

    /*Thêm mới Product*/
    @ApiOperation(value = "Thêm mới Product")
    @PostMapping
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO){
        return productService.saveProduct(productDTO);
    }

    /*Chỉnh sửa Product*/
    @ApiOperation(value = "Chỉnh sửa product")
    @PutMapping("/{id}")
    public ProductDTO updateProduct(
            @PathVariable("id") Long id,
            @RequestBody ProductDTO productDTO
    ){
        return productService.updateProduct(id,productDTO);
    }

    /*Thay đổi trạng thái của sản phẩm
    * Trường hợp trạng thái đang hoạt động sẽ được thay đổi thành ngừng kinh doanh
    * Ngược lại, Trường hợp sản phẩm bị ngừng kinh doanh thì sẽ được đổi thành hoạt động trở lại
    * */
    @ApiOperation(value = "Thay đổi trạng thái của sản phẩm")
    @PutMapping(value = "/enable/{id}")
    public ProductDTO changeStatusProduct(@PathVariable("id") Long id){
        return productService.changeProductStatus(id);
    }
}
