package com.api.product.controllers;

import com.api.product.entities.Discount;
import com.api.product.services.DiscountService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/discount")
public class DiscountController {
    private DiscountService service;

    @Autowired
    public void setService(DiscountService service) {
        this.service = service;
    }

    @GetMapping
    @ApiOperation(value = "Tìm tất cả khuyến mãi")
    public ResponseEntity<Page<Discount>> findAllDiscount(
            @RequestParam(value = "limit") Integer limit,
            @RequestParam(value = "page") Integer page
    ) {
        if (limit != null && page != null)
            return new ResponseEntity<>(service.findAllDiscount(limit, page), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Tìm Discount dựa vào Id")
    public ResponseEntity<Discount> findDiscountById(
            @ApiParam(value = "Id Discount")
            @PathVariable(value = "id") Long id
    ) {
        return new ResponseEntity<>(service.findDiscountById(id), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Thêm mới Discount")
    public ResponseEntity<Discount> createNewDiscount(@RequestBody Discount discount) {
        if (discount != null)
            return new ResponseEntity<>(service.save(discount), HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
