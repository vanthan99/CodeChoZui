package com.api.product.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "category")
@JsonIgnoreProperties({"createdAt","updatedAt","products"})
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    // Mapping to Product table;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "category")
    private List<Product> products;
}
