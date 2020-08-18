package com.api.product.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value="Discount model")
public class DiscountDTO {
    private Long id;
    private Date endDay;
    private Date startDay;
    private String name;
    private String note;
}
