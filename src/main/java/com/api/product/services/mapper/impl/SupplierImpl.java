package com.api.product.services.mapper.impl;

import com.api.product.entities.Supplier;
import com.api.product.services.dto.SupplierDTO;
import com.api.product.services.mapper.SupplierMapper;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class SupplierImpl implements SupplierMapper {
    @Override
    public SupplierDTO toDTO(Supplier supplier) {
        SupplierDTO dto = new SupplierDTO();
        dto.setId(supplier.getId());
        dto.setAddress(supplier.getAddress());
        dto.setDescription(supplier.getDescription());
        dto.setPhoneNumber(supplier.getPhoneNumber());
        return dto;
    }

    @Override
    public List<SupplierDTO> toDTOList(List<Supplier> suppliers) {
        List<SupplierDTO> supplierDTOS = new ArrayList<>();
        for (Supplier item : suppliers){
            supplierDTOS.add(toDTO(item));
        }
        return supplierDTOS;
    }

    @Override
    public Supplier toEntity(SupplierDTO dto) {
        Supplier supplier = new Supplier();
        supplier.setId(dto.getId());
        supplier.setAddress(dto.getAddress());
        supplier.setDescription(dto.getDescription());
        supplier.setPhoneNumber(dto.getPhoneNumber());
        return supplier;
    }
}
