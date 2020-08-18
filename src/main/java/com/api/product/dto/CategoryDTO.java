package com.api.product.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "Category model")
public class CategoryDTO {
    private Long id;
    private String name;
}
