package com.api.product.mapper;

import com.api.product.entities.DiscountDetail;
import com.api.product.dto.DiscountDetailDTO;

import java.util.List;

public interface DiscountDetailMapper {
    DiscountDetailDTO toDTO(DiscountDetail discountDetail);
    List<DiscountDetailDTO> toDTOList(List<DiscountDetail> discountDetails);
    DiscountDetail toEntity(DiscountDetailDTO dto);
}
