package com.api.product.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value="Supplier model")
public class SupplierDTO {
    private Long id;
    private String address;
    private String description;
    private String phoneNumber;
}
