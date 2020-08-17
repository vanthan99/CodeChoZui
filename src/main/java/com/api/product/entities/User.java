package com.api.product.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    private String username;

    @Column
    private String fullname;

    @Column(nullable = false)
    private String password;

    @Column
    private Boolean enable = true;

    @Column
    @Temporal(TemporalType.DATE)
    private Date birthDay;

    @Column(length = 10)
    private String phoneNumber;

    @Column
    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedAt;

    // Mapping to Bill table
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private List<Bill> bills;

    // Mapping to Role table
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            joinColumns = {
                    @JoinColumn(name = "user_id",nullable = false,updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id",nullable = false,updatable = false)
            }
    )
    private List<Role> roles;
}
