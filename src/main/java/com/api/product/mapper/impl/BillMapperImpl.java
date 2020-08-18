package com.api.product.mapper.impl;

import com.api.product.entities.Bill;
import com.api.product.repositories.BillStatusRepository;
import com.api.product.dto.BillDTO;
import com.api.product.mapper.BillMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BillMapperImpl implements BillMapper {
    private final BillStatusRepository billStatusRepository;

    @Override
    public BillDTO toDTO(Bill bill) {
        BillDTO dto = new BillDTO();
        dto.setId(bill.getId());
        dto.setBillStatusId(bill.getBillStatus().getId());
        dto.setTotal(bill.getTotal());
        return dto;
    }

    @Override
    public List<BillDTO> toDTOList(List<Bill> bills) {
        List<BillDTO> billDTOS = new ArrayList<>();
        for (Bill item : bills){
            billDTOS.add(toDTO(item));
        }
        return billDTOS;
    }

    @Override
    public Bill toEntity(BillDTO dto) {
        Bill bill = new Bill();
        bill.setId(dto.getId());
        bill.setTotal(dto.getTotal());
        bill.setBillStatus(billStatusRepository.getOne(dto.getBillStatusId()));
        return bill;
    }
}
