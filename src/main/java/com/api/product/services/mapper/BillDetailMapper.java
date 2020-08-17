package com.api.product.services.mapper;

import com.api.product.entities.Bill;
import com.api.product.entities.BillDetail;
import com.api.product.services.dto.BillDTO;
import com.api.product.services.dto.BillDetailDTO;

import java.util.List;

public interface BillDetailMapper {
    BillDetailDTO toDTO(BillDetail billDetail);
    List<BillDetailDTO> toDTOList(List<BillDetail> billDetails);
    BillDetail toEntity(BillDetailDTO dto);
}
