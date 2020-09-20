package com.api.product.controllers;

import com.api.product.entities.Supplier;
import com.api.product.services.SupplierService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/supplier")
public class SupplierController {
    private SupplierService service;

    @Autowired
    public void setSupplierService(SupplierService supplierService) {
        this.service = supplierService;
    }

    /*
     * find  All Supplier
     * */
    @GetMapping
    @ApiOperation(value = "Tìm tất cả Supplier")
    public ResponseEntity<Page<Supplier>> findAllSupplier(
            @RequestParam(value = "limit") Integer limit,
            @RequestParam(value = "page") Integer page
    ) {
        if (limit != null && page != null)
            return new ResponseEntity<>(service.findAllSupplierPagination(page, limit), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Find Supplier By Id
    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Tìm kiếm Supplier dựa vào Id")
    public Supplier findSupplierById(
            @PathVariable(value = "id") Long id
    ) {
        return service.findSupplierById(id);
    }

    // Create Supplier
    @ApiOperation(value = "Thêm mơi Supplier")
    @PostMapping
    public ResponseEntity<Supplier> save(@RequestBody Supplier supplier) {
        System.out.println("supplier:" + supplier);
        if (supplier != null)
            return new ResponseEntity<>(service.save(supplier), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*
    Update Supplier
    Input: id Supplier, Supplier
    Output: SupplierDTO
    */

    @PutMapping("/{id}")
    @ApiOperation(value = "Chỉnh sửa Supplier")
    public ResponseEntity<Supplier> update(@RequestBody Supplier supplier, @PathVariable("id") Long id) {
        return new ResponseEntity<>(service.update(id, supplier), HttpStatus.OK);
    }
}
