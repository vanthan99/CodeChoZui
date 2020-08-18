package com.api.product.repositories;

import com.api.product.entities.DiscountDetail;
import com.api.product.entities.DiscountDetailIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountDetailRepository extends JpaRepository<DiscountDetail, DiscountDetailIdentity> {
}
