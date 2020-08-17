package com.api.product.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DiscountDetail {

    @EmbeddedId
    private DiscountDetailIdentity discountDetailIdentity;

    @Column
    private Float discountRate;

    // Mapping to Product table
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("productId")
    private Product product;

    // Mapping to Discount table
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("discountId")
    private Discount discount;
}
