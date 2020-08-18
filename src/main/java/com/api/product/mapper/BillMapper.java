package com.api.product.mapper;

import com.api.product.entities.Bill;
import com.api.product.dto.BillDTO;

import java.util.List;

public interface BillMapper {
    BillDTO toDTO(Bill bill);
    List<BillDTO> toDTOList(List<Bill> bills);
    Bill toEntity(BillDTO dto);
}
