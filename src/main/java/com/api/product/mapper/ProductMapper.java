package com.api.product.mapper;

import com.api.product.entities.Product;
import com.api.product.dto.ProductDTO;
import java.util.List;

public interface ProductMapper {
    ProductDTO toDTO(Product product);
    List<ProductDTO> toDTOList(List<Product> products);
    Product toEntity(ProductDTO dto);
}
