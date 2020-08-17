package com.api.product.controllers;

import com.api.product.services.dto.DiscountDTO;
import com.api.product.services.handle.DiscountService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/discount")
@RequiredArgsConstructor
public class DiscountController {
    private final DiscountService service;

    @GetMapping
    @ApiOperation(value = "Tìm tất cả khuyến mãi")
    public List<DiscountDTO> findAllDiscount(){
        return service.findAllDiscount();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Tìm Discount dựa vào Id")
    public DiscountDTO findDiscountById(
            @ApiParam(value = "Id Discount")
            @PathVariable(value = "id") Long id
    ){
        return service.findDiscountById(id);
    }

    @PostMapping
    @ApiOperation(value = "Thêm mới Discount")
    public DiscountDTO createNewDiscount(@RequestBody DiscountDTO dto){
        return service.save(dto);
    }


}
