package com.api.product.mapper;

import com.api.product.dto.ProductDTO;
import com.api.product.entities.Product;
import java.util.List;

public interface IProductMapper {
    ProductDTO toProductDto(Product product);
    List<ProductDTO> toProductDtoList(List<Product> products);
    Product toProduct(ProductDTO productDTO);
}
