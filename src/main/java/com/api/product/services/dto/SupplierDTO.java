package com.api.product.services.dto;

import lombok.Data;

@Data
public class SupplierDTO {
    private Long id;
    private String address;
    private String description;
    private String phoneNumber;
}
