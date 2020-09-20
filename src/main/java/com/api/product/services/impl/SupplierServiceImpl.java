package com.api.product.services.impl;

import com.api.product.entities.Supplier;
import com.api.product.repositories.SupplierRepository;
import com.api.product.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Supplier findSupplierById(Long id) {
        return supplierRepository.getOne(id);
    }


    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier update(Long id, Supplier supplier) {
        supplier.setId(id);
        return supplierRepository.save(supplier);
    }

    @Override
    public Page<Supplier> findAllSupplierPagination(int page, int limit) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        return supplierRepository.findAll(pageable);
    }

//    @PostConstruct
//    public void createData(){
//        for (int i = 1 ; i <= 10; i++){
//            Supplier supplier = new Supplier();
//            supplier.setPhoneNumber("09011212"+i);
//            supplier.setDescription("Đây là mô tả cho nhà cung cấp số "+ i);
//            supplier.setAddress("Đây là địa chỉ của nhà cung cấp số " +i);
//            supplier.setName("Nhà cung cấp số "+ i);
//            supplierRepository.save(supplier);
//        }
//    }


}
