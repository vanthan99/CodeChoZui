package com.api.product.controllers;

import com.api.product.entities.Product;
import com.api.product.services.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    /*Tìm kiếm tất cả Product*/
    @GetMapping
    @ApiOperation(value = "Danh sách tất cả Product")
    public Page<Product> findAllProduct(
            @ApiParam(value = "Id của Category")
            @RequestParam(value = "catId", required = false) Long catId,

            @ApiParam(value = "Id của Supplier")
            @RequestParam(value = "supId", required = false) Long supId,

            @ApiParam(value = "limit")
            @RequestParam(value = "limit", required = false) Integer limit,

            @RequestParam(value = "page", required = false) Integer page
    ) {
        // Trường hợp tìm kiếm theo category
//        if (!(catId == null)) {
//            return productService.findAllProductByCategory(catId, limit, page);
//        }

        // Trường hợp tìm kiếm theo supplier
//        else if (!(supId == null)) {
//            return productService.findAllProductBySupplier(supId, limit, page);
//        }

        // Trường hợp còn lại. Tìm kiếm tất cả products
//        else return productService.findAllProduct();
        return productService.findAllProduct(page, limit);
    }

    /*Tìm kiếm tất cả Product đang hoạt động*/
    @GetMapping(value = "enable")
    @ApiOperation(value = "Tìm kiếm tất cả product đang hoạt động")
    public ResponseEntity<Page<Product>> findAllProductIsActive(
            @RequestParam(value = "limit") Integer limit,
            @RequestParam(value = "page") Integer page
    ) {
        if (limit != null && page != null)
            return new ResponseEntity<>(productService.findAllProductIsEnable(limit, page), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*Tìm kiếm tất cả Product ngừng hoạt động*/
    @GetMapping(value = "/notEnable")
    @ApiOperation(value = "Tìm kiếm tất cả product không hoạt động")
    public ResponseEntity<Page<Product>> findAllProductIsNotActive(
            @RequestParam(value = "limit") Integer limit,
            @RequestParam(value = "page") Integer page
    ) {
        if (limit != null && page != null)
            return new ResponseEntity<>(productService.findAllProduct(page, limit), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*Tìm kiếm Product dựa vào Id*/
    @ApiOperation(value = "Tìm kiếm Product theo Id")
    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(
            @PathVariable(value = "id") Long id
    ) {
        return new ResponseEntity<>(productService.findProductById(id), HttpStatus.OK);
    }

    /*Thêm mới Product*/
    @ApiOperation(value = "Thêm mới Product")
    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        if (product == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    /*Chỉnh sửa Product*/
    @ApiOperation(value = "Chỉnh sửa product")
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable("id") Long id,
            @RequestBody Product product
    ) {
        if (id == null || product == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.OK);
    }

    /*Thay đổi trạng thái của sản phẩm
     * Trường hợp trạng thái đang hoạt động sẽ được thay đổi thành ngừng kinh doanh
     * Ngược lại, Trường hợp sản phẩm bị ngừng kinh doanh thì sẽ được đổi thành hoạt động trở lại
     * */
    @ApiOperation(value = "Thay đổi trạng thái của sản phẩm")
    @PutMapping(value = "/enable/{id}")
    public ResponseEntity<Product> changeStatusProduct(@PathVariable("id") Long id) {
        if (id == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(productService.changeProductStatus(id), HttpStatus.OK);
    }
}
