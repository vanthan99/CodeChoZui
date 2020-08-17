package com.api.product.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class BillStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String statusName;

    // Mapping to Bill table
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "billStatus")
    private List<Bill> bills;
}
