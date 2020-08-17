package com.api.product.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long total;

    @CreationTimestamp
    private Date createdAt;

    // Mapping to User table
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private User user;

    // Mapping to Bill Status table
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bill_status")
    private BillStatus billStatus;

    // Mapping to Bill Detail table
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "bill")
    List<BillDetail> billDetails;
}
