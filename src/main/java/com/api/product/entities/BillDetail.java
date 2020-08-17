package com.api.product.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class BillDetail {
    @EmbeddedId
    private BillDetailIdentity billDetailIdentity;

    @Column
    private Integer quantity;

    @Column
    private Long price;

    // Mapping to Bill table
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("billId")
    private Bill bill;

    // Mapping to Product table
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("productId")
    private Product product;
}
