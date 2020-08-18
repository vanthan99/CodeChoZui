package com.api.product.mapper;

import com.api.product.entities.Supplier;
import com.api.product.dto.SupplierDTO;
import java.util.List;

public interface SupplierMapper {
    SupplierDTO toDTO(Supplier supplier);
    List<SupplierDTO> toDTOList(List<Supplier> suppliers);
    Supplier toEntity(SupplierDTO dto);
}
