package com.api.product.services.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BillDetailDTO {
    private Long billId;
    private Long productId;
    private Long price;
    private Integer quantity;
}
