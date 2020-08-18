package com.api.product.services.impl;

import com.api.product.entities.DiscountDetail;
import com.api.product.entities.DiscountDetailIdentity;
import com.api.product.repositories.DiscountDetailRepository;
import com.api.product.repositories.ProductRepository;
import com.api.product.dto.DiscountDetailDTO;
import com.api.product.services.DiscountDetailService;
import com.api.product.mapper.DiscountDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DiscountDetailServiceImpl implements DiscountDetailService {
    @Autowired
    private DiscountDetailRepository discountDetailRepository;

    @Autowired
    private DiscountDetailMapper discountDetailMapper;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public DiscountDetailDTO createNewDetail(DiscountDetailDTO discountDetailDTO) {
        DiscountDetailIdentity identity = new DiscountDetailIdentity(
                discountDetailDTO.getProductId(),
                discountDetailDTO.getDiscountId()
        );
        DiscountDetail discountDetail = new DiscountDetail();
        discountDetail.setDiscountDetailIdentity(identity);
        discountDetail.setDiscountRate(discountDetailDTO.getDiscountRate());

        discountDetailRepository.save(discountDetail);
        return discountDetailMapper.toDTO(discountDetail);
    }

    @Override
    public void removeDiscountDetailByProductId(Long productId) {
        List<DiscountDetail> discountDetails = productRepository.getOne(productId).getDiscountDetails();
        for (DiscountDetail item : discountDetails){
            discountDetailRepository.delete(item);
        }
    }

    @Override
    public void updateDiscountDetailById(DiscountDetailIdentity identity) {
        DiscountDetail discountDetail = discountDetailRepository.getOne(identity);
        
    }
}
