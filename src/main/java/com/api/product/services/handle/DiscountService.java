package com.api.product.services.handle;

import com.api.product.services.dto.DiscountDTO;

import java.util.List;

public interface DiscountService {

    /*Find all discount*/
    List<DiscountDTO> findAllDiscount();

    /*Find Discount by id*/
    DiscountDTO findDiscountById(Long id);

    /*Add new discount*/
    DiscountDTO save(DiscountDTO discountDTO);

}
