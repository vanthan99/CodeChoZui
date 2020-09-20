package com.api.product.services.impl;

import com.api.product.entities.Discount;
import com.api.product.repositories.DiscountRepository;
import com.api.product.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class DiscountServiceImpl implements DiscountService {
    private DiscountRepository repo;

    @Autowired
    public void setRepo(DiscountRepository repo) {
        this.repo = repo;
    }


    @Override
    public Page<Discount> findAllDiscount(int limit, int page) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        return repo.findAll(pageable);
    }

    @Override
    public Discount findDiscountById(Long id) {
        return repo.getOne(id);
    }

    @Override
    public Discount save(Discount discount) {
        return repo.save(discount);
    }


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


}
