package com.api.product.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value="Product model")
public class ProductDTO {
    private Long id;
    private Long catId;
    private Long supId;
    private String description;
    private String name;
    private Long price;
    private Integer quantity;
}
