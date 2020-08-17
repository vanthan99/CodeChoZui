package com.api.product.services.mapper;

import com.api.product.entities.Bill;
import com.api.product.entities.Supplier;
import com.api.product.services.dto.BillDTO;
import com.api.product.services.dto.SupplierDTO;

import java.util.List;

public interface SupplierMapper {
    SupplierDTO toDTO(Supplier supplier);
    List<SupplierDTO> toDTOList(List<Supplier> suppliers);
    Supplier toEntity(SupplierDTO dto);
}
