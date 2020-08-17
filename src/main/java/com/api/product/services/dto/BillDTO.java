package com.api.product.services.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BillDTO {
    private Long id;
    private Long total;
    private Long billStatusId;
}
