package com.api.product.services;

import com.api.product.dto.DiscountDTO;

import java.util.List;

public interface DiscountService {

    /*Find all discount*/
    List<DiscountDTO> findAllDiscount();

    /*Find Discount by id*/
    DiscountDTO findDiscountById(Long id);

    /*Add new discount*/
    DiscountDTO save(DiscountDTO discountDTO);

}
