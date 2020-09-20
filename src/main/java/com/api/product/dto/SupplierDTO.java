package com.api.product.dto;

import com.api.product.entities.Supplier;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value="Supplier model")
public class SupplierDTO {
    private Long id;
    private String name;
    private String address;
    private String description;
    private String phoneNumber;

}
