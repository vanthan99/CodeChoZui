package com.api.product.services.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DiscountDTO {
    private Long id;
    private Date endDay;
    private Date startDay;
    private String name;
    private String note;
}
