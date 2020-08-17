package com.api.product.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private String name;

    // Mapping to User table
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "roles")
    private List<User> users;
}
