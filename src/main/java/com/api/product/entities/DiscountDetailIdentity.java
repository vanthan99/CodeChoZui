package com.api.product.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDetailIdentity implements Serializable {
    private Long discountId;
    private Long productId;
}
