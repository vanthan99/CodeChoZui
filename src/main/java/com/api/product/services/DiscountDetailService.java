package com.api.product.services;

import com.api.product.entities.DiscountDetailIdentity;
import com.api.product.dto.DiscountDetailDTO;

public interface DiscountDetailService {

    /* Create new discount detail */
    DiscountDetailDTO createNewDetail(DiscountDetailDTO discountDetailDTO);

    /*  Remove discount detail by product id */
    void removeDiscountDetailByProductId(Long productId);

    /* Edit discount detail */
    void updateDiscountDetailById(DiscountDetailIdentity identity);
}
