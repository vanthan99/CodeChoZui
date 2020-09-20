package com.api.product.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private String name;

    // Mapping to User table
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "role")
    private List<User> users;
}
