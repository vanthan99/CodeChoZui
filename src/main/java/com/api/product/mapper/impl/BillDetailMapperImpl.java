package com.api.product.mapper.impl;

import com.api.product.entities.BillDetail;
import com.api.product.entities.BillDetailIdentity;
import com.api.product.repositories.BillRepository;
import com.api.product.repositories.ProductRepository;
import com.api.product.dto.BillDetailDTO;
import com.api.product.mapper.BillDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BillDetailMapperImpl implements BillDetailMapper {
    private final ProductRepository productRepository;
    private final BillRepository billRepository;
    @Override
    public BillDetailDTO toDTO(BillDetail billDetail) {
        BillDetailDTO dto = new BillDetailDTO();
        dto.setBillId(billDetail.getBillDetailIdentity().getBillId());
        dto.setProductId(billDetail.getBillDetailIdentity().getProductId());
        dto.setPrice(billDetail.getPrice());
        dto.setQuantity(billDetail.getQuantity());
        return dto;
    }

    @Override
    public List<BillDetailDTO> toDTOList(List<BillDetail> billDetails) {
        List<BillDetailDTO> billDetailDTOS = new ArrayList<>();
        for (BillDetail item : billDetails){
            billDetailDTOS.add(toDTO(item));
        }
        return billDetailDTOS;
    }

    @Override
    public BillDetail toEntity(BillDetailDTO dto) {
        BillDetailIdentity identity = new BillDetailIdentity();
        identity.setBillId(dto.getBillId());
        identity.setProductId(dto.getProductId());

        BillDetail billDetail = new BillDetail();
        billDetail.setBillDetailIdentity(identity);
        billDetail.setPrice(dto.getPrice());
        billDetail.setQuantity(dto.getQuantity());
        billDetail.setBill(billRepository.getOne(dto.getBillId()));
        billDetail.setProduct(productRepository.getOne(dto.getProductId()));
        return billDetail;
    }
}
