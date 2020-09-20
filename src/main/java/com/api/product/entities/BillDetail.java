package com.api.product.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bill_detail")
@Data
public class BillDetail {
    @EmbeddedId
    private BillDetailIdentity billDetailIdentity;

    @Column
    private Integer quantity;

    @Column
    private Long price;

    @Column
    private Float discountRate;

    // Mapping to Bill table
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("billId")
    private Bill bill;

    // Mapping to Product table
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("productId")
    private Product product;
}
