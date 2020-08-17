package com.api.product.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 10)
    private String phoneNumber;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    // Mapping to Product table
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "supplier")
    private List<Product> products;
}
