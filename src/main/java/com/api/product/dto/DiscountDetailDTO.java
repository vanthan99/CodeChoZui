package com.api.product.dto;

import lombok.Data;

@Data
public class DiscountDetailDTO {
    private Long discountId;
    private Long productId;
    private Float discountRate;
}
