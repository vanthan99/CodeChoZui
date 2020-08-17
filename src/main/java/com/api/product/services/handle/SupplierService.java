package com.api.product.services.handle;

import com.api.product.entities.Supplier;
import com.api.product.services.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
//    find supplier by id
    SupplierDTO findSupplierById(Long id);

//    find all supplier
    List<SupplierDTO> findAllSupplier();

//    save Supplier
    SupplierDTO save(SupplierDTO supplierDTO);

//    update Supplier
    SupplierDTO update(Long id, SupplierDTO supplierDTO);
}

