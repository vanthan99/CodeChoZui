package com.api.product.services;

import com.api.product.dto.DiscountDTO;
import com.api.product.entities.Discount;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DiscountService {

    /*Find all discount*/
    Page<Discount> findAllDiscount(int limit, int page);

    /*Find Discount by id*/
    Discount findDiscountById(Long id);

    /*Add new discount*/
    Discount save(Discount discount);

}
