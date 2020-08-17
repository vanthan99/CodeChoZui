package com.api.product.entities;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column
    private Long price;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private Integer quantity;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    private Boolean enable = true;

    // mapping to category table
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cat_id")
    private Category category;

    // mapping to billDetail table
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product")
    List<BillDetail> billDetails;

    // mapping to supplier table
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sup_id")
    private Supplier supplier;

    // mapping to discount detail
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product")
    private List<DiscountDetail> discountDetails;
}
