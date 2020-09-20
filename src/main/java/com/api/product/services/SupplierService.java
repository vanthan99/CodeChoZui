package com.api.product.services;

import com.api.product.entities.Supplier;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SupplierService {
    //    find supplier by id
    Supplier findSupplierById(Long id);

    //    save Supplier
    Supplier save(Supplier supplier);

    //    update Supplier
    Supplier update(Long id, Supplier supplier);

    Page<Supplier> findAllSupplierPagination(int page, int limit);
}

