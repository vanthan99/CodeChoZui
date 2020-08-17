package com.api.product.services.mapper;

import com.api.product.entities.Bill;
import com.api.product.entities.Product;
import com.api.product.services.dto.BillDTO;
import com.api.product.services.dto.ProductDTO;

import java.util.List;

public interface ProductMapper {
    ProductDTO toDTO(Product product);
    List<ProductDTO> toDTOList(List<Product> products);
    Product toEntity(ProductDTO dto);
}
