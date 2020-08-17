package com.api.product.services.handle.impl;

import com.api.product.entities.Discount;
import com.api.product.repositories.DiscountRepository;
import com.api.product.services.dto.DiscountDTO;
import com.api.product.services.handle.DiscountService;
import com.api.product.services.mapper.DiscountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {
    private final DiscountMapper discountMapper;
    private final DiscountRepository discountRepository;

//    @PostConstruct
//    public void initData(){
//        Date date = new Date();
//        Date date2 = new Date();
//        date.setTime(20191220);
//        date2.setTime(20191222);
//        for (int i = 1; i < 20; i++) {
//            Discount discount = new Discount();
//            discount.setName("Khuyến mãi số "+i);
//            discount.setNote("Ghi chú cho khuyến mãi số " + i);
//            discount.setStartDay(date);
//            discount.setEndDay(date2);
//            discountRepository.save(discount);
//        }
//    }

    @Override
    public List<DiscountDTO> findAllDiscount() {
        List<Discount> discounts = discountRepository.findAll();
        return discountMapper.toDTOList(discounts);
    }

    @Override
    public DiscountDTO findDiscountById(Long id) {
        Discount discount = discountRepository.getOne(id);
        return discountMapper.toDTO(discount);
    }

    @Override
    public DiscountDTO save(DiscountDTO discountDTO) {
        Discount discount = discountMapper.toEntity(discountDTO);
        discountRepository.save(discount);
        return discountMapper.toDTO(discount);
    }
}
