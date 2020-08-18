package com.api.product.services.impl;

import com.api.product.entities.Supplier;
import com.api.product.repositories.SupplierRepository;
import com.api.product.dto.SupplierDTO;
import com.api.product.services.SupplierService;
import com.api.product.mapper.SupplierMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

//    @PostConstruct
//    public void createData(){
//        for (int i = 1 ; i <= 9; i++){
//            Supplier supplier = new Supplier();
//            supplier.setPhoneNumber("090112120"+i);
//            supplier.setDescription("Đây là mô tả cho nhà cung cấp số "+ i);
//            supplier.setAddress("Đây là địa chỉ của nhà cung cấp số " +i);
//            supplier.setName("Nhà cung cấp số "+ i);
//            supplierRepository.save(supplier);
//        }
//    }

    @Override
    public SupplierDTO findSupplierById(Long id) {
        Supplier supplier = supplierRepository.getOne(id);
        return supplierMapper.toDTO(supplier);
    }

    @Override
    public List<SupplierDTO> findAllSupplier() {
        return supplierMapper.toDTOList(supplierRepository.findAll())   ;
    }

    @Override
    public SupplierDTO save(SupplierDTO supplierDTO) {
        Supplier supplier = supplierMapper.toEntity(supplierDTO);
        supplierRepository.save(supplier);
        return supplierMapper.toDTO(supplier);
    }

    @Override
    public SupplierDTO update(Long id, SupplierDTO supplierDTO) {
        Supplier supplier = supplierMapper.toEntity(supplierDTO);
        supplier.setId(id);
        supplierRepository.save(supplier);
        return supplierMapper.toDTO(supplier);
    }
}
