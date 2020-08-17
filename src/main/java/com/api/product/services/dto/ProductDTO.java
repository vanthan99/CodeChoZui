package com.api.product.services.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;
    private Long catId;
    private Long supId;
    private String description;
    private String name;
    private Long price;
    private Integer quantity;
}
