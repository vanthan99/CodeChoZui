package com.api.product.mapper.impl;

import com.api.product.entities.Discount;
import com.api.product.dto.DiscountDTO;
import com.api.product.mapper.DiscountMapper;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class DiscountMapperImpl implements DiscountMapper {
    @Override
    public DiscountDTO toDTO(Discount discount) {
        DiscountDTO dto = new DiscountDTO();
        dto.setId(discount.getId());
        dto.setName(discount.getName());
        dto.setNote(discount.getNote());
        dto.setStartDay(discount.getStartDay());
        dto.setEndDay(discount.getEndDay());
        return dto;
    }

    @Override
    public List<DiscountDTO> toDTOList(List<Discount> discounts) {
        List<DiscountDTO> discountDTOS = new ArrayList<>();
        for (Discount item : discounts){
            discountDTOS.add(toDTO(item));
        }
        return discountDTOS;
    }

    @Override
    public Discount toEntity(DiscountDTO dto) {
        Discount discount = new Discount();
        discount.setId(dto.getId());
        discount.setName(dto.getName());
        discount.setNote(dto.getNote());
        discount.setEndDay(dto.getEndDay());
        discount.setStartDay(dto.getStartDay());
        return discount;
    }
}
