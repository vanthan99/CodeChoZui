package com.api.product.controllers;

import com.api.product.dto.SupplierDTO;
import com.api.product.services.SupplierService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/supplier")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    /*
    * find  All Supplier
    * */
    @GetMapping
    @ApiOperation(value = "Tìm tất cả Supplier")
    public List<SupplierDTO> findAllSupplier(){
        return supplierService.findAllSupplier();
    }

    // Find Category By Id
    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Tìm kiếm Supplier dựa vào Id")
    public SupplierDTO findSupplierById(
            @ApiParam(value = "id cần tìm kiếm supplier") @PathVariable("id") Long id
    ){
        return supplierService.findSupplierById(id);
    }

    // Create Supplier
    @ApiOperation(value = "Thêm mơi Supplier")
    @PostMapping
    public SupplierDTO save(@RequestBody SupplierDTO supplierDTO) {
        return supplierService.save(supplierDTO);
    }

    /*
    Update Supplier
    Input: id Supplier, Supplier
    Output: SupplierDTO
    */

    @PutMapping("/{id}")
    @ApiOperation(value = "Chỉnh sửa Supplier")
    public SupplierDTO update(@RequestBody SupplierDTO supplierDTO,@PathVariable("id") Long id){
        return supplierService.update(id,supplierDTO);
    }
}
