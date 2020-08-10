package com.api.product.mapper.impl;

import com.api.product.dto.ProductDTO;
import com.api.product.entities.Product;
import com.api.product.mapper.IProductMapper;
import com.api.product.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper implements IProductMapper {
    @Autowired
    private CategoryService categoryService;
    @Override
    public ProductDTO toProductDto(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        dto.setCatId(product.getCategory().getId());
        return dto;
    }

    @Override
    public List<ProductDTO> toProductDtoList(List<Product> products) {
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products){
            productDTOS.add(toProductDto(product));
        }
        return productDTOS;
    }

    @Override
    public Product toProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setCategory(categoryService.findById(productDTO.getCatId()));
        return product;
    }
}
