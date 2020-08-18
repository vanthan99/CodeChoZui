package com.api.product.dto;

import lombok.Data;

@Data
public class BillDetailDTO {
    private Long billId;
    private Long productId;
    private Long price;
    private Integer quantity;
}
