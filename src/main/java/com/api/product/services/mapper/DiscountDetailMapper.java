package com.api.product.services.mapper;

import com.api.product.entities.Discount;
import com.api.product.entities.DiscountDetail;
import com.api.product.services.dto.DiscountDTO;
import com.api.product.services.dto.DiscountDetailDTO;

import java.util.List;

public interface DiscountDetailMapper {
    DiscountDetailDTO toDTO(DiscountDetail discountDetail);
    List<DiscountDetailDTO> toDTOList(List<DiscountDetail> discountDetails);
    DiscountDetail toEntity(DiscountDetailDTO dto);
}
