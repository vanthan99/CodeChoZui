package com.api.product.services;

import com.api.product.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;

public interface ProductService {

    /*
        Find Product By id
    */
//    @PreAuthorize("hasAuthority('ADMIN')")
    Product findProductById(Long id);

    /*
     * Find List product*/
//    @PreAuthorize("hasAuthority('ADMIN')")
    Page<Product> findAllProduct(int page, int limit);

    // Create Product
    @PreAuthorize("hasAuthority('ADMIN')")
    Product saveProduct(Product product);

    // update product
    @PreAuthorize("hasAuthority('ADMIN')")
    Product updateProduct(Long id, Product product);

    // find products is active
    @PreAuthorize("hasAuthority('ADMIN')")
    Page<Product> findAllProductIsEnable(int limit, int page);

    // find Products is not active
    Page<Product> findAllProductIsNotEnable(int limit, int page);

    // find Products by category
    @PreAuthorize("hasAuthority('ADMIN')")
    Page<Product> findAllProductByCategory(Long catId, int limit, int page);

    // find products by supplier
    @PreAuthorize("hasAuthority('ADMIN')")
    Page<Product> findAllProductBySupplier(Long supId, int limit, int page);

    // Change Status Product
    @PreAuthorize("hasAuthority('ADMIN')")
    Product changeProductStatus(Long id);

    // ListProduct pagination


    // ListProduct by Supplier has pagination


}
