package com.api.product.dto;

import lombok.Data;

@Data
public class BillDTO {
    private Long id;
    private Long total;
    private Long billStatusId;
}
