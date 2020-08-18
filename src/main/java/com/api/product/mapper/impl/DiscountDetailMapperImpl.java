package com.api.product.mapper.impl;

import com.api.product.entities.DiscountDetail;
import com.api.product.entities.DiscountDetailIdentity;
import com.api.product.repositories.DiscountRepository;
import com.api.product.repositories.ProductRepository;
import com.api.product.dto.DiscountDetailDTO;
import com.api.product.mapper.DiscountDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DiscountDetailMapperImpl implements DiscountDetailMapper {
    private final ProductRepository productRepository;
    private final DiscountRepository discountRepository;
    @Override
    public DiscountDetailDTO toDTO(DiscountDetail discountDetail) {
        DiscountDetailDTO dto = new DiscountDetailDTO();
        dto.setDiscountId(discountDetail.getDiscountDetailIdentity().getDiscountId());
        dto.setProductId(discountDetail.getDiscountDetailIdentity().getProductId());
        dto.setDiscountRate(discountDetail.getDiscountRate());
        return dto;
    }

    @Override
    public List<DiscountDetailDTO> toDTOList(List<DiscountDetail> discountDetails) {
        List<DiscountDetailDTO> discountDetailDTOS = new ArrayList<>();
        for (DiscountDetail item : discountDetails){
            discountDetailDTOS.add(toDTO(item));
        }
        return discountDetailDTOS;
    }

    @Override
    public DiscountDetail toEntity(DiscountDetailDTO dto) {
        DiscountDetailIdentity identity = new DiscountDetailIdentity();
        identity.setDiscountId(dto.getDiscountId());
        identity.setProductId(dto.getProductId());

        DiscountDetail discountDetail = new DiscountDetail();
        discountDetail.setDiscountDetailIdentity(identity);
        discountDetail.setProduct(productRepository.getOne(dto.getProductId()));
        discountDetail.setDiscount(discountRepository.getOne(dto.getDiscountId()));
        discountDetail.setDiscountRate(dto.getDiscountRate());
        return discountDetail;
    }
}
