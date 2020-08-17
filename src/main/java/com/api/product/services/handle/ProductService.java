package com.api.product.services.handle;

import com.api.product.services.dto.ProductDTO;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.jnlp.ClipboardService;
import java.util.List;

public interface ProductService {

    /*
        Find Product By id
    */
    ProductDTO findProductById(Long id);

    /*
    * Find List product*/
    List<ProductDTO> findAllProduct();

    // Create Product
    ProductDTO saveProduct(ProductDTO productDTO);

    // update product
    ProductDTO updateProduct(Long id, ProductDTO productDTO);

    // find products is active
    List<ProductDTO> findAllProductIsActive();

    // find Products is not active
    List<ProductDTO> findAllProductIsNotActive();

    // find Products by category
    List<ProductDTO> findAllProductByCategory(Long catId);

    // find products by supplier
    List<ProductDTO> findAllProductBySupplier(Long supId);

    // Change Status Product
    ProductDTO changeProductStatus(Long id);
}
