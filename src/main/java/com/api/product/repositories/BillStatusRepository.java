package com.api.product.repositories;

import com.api.product.entities.BillStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillStatusRepository extends JpaRepository<BillStatus,Long> {
}
