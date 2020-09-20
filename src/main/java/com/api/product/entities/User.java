package com.api.product.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId",nullable = false)
    private Role role;

}
