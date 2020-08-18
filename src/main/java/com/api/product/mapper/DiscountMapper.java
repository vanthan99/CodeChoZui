package com.api.product.mapper;

import com.api.product.entities.Discount;
import com.api.product.dto.DiscountDTO;
import java.util.List;

public interface DiscountMapper {
    DiscountDTO toDTO(Discount discount);
    List<DiscountDTO> toDTOList(List<Discount> discounts);
    Discount toEntity(DiscountDTO dto);
}
