package com.api.product.mapper.impl;

import com.api.product.entities.Product;
import com.api.product.repositories.CategoryRepository;
import com.api.product.repositories.SupplierRepository;
import com.api.product.dto.ProductDTO;
import com.api.product.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductMapperImpl implements ProductMapper {
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;

    @Override
    public ProductDTO toDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setCatId(product.getCategory().getId());
        dto.setSupId(product.getSupplier().getId());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity())  ;
        return dto;
    }

    @Override
    public List<ProductDTO> toDTOList(List<Product> products) {
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product item : products){
            productDTOS.add(toDTO(item));
        }
        return productDTOS;
    }

    @Override
    public Product toEntity(ProductDTO dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setCategory(categoryRepository.getOne(dto.getCatId()));
        product.setSupplier(supplierRepository.getOne(dto.getSupId()));
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setQuantity(dto.getQuantity());
        return product;
    }
}
