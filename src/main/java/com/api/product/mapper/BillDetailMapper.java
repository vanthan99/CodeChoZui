package com.api.product.mapper;

import com.api.product.entities.BillDetail;
import com.api.product.dto.BillDetailDTO;

import java.util.List;

public interface BillDetailMapper {
    BillDetailDTO toDTO(BillDetail billDetail);
    List<BillDetailDTO> toDTOList(List<BillDetail> billDetails);
    BillDetail toEntity(BillDetailDTO dto);
}
