package com.api.product.repositories;

import com.api.product.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.enable = true")
    Page<Product> findAllProductIsEnable(Pageable pageable);

    @Query("select p from Product p where p.enable = true")
    List<Product> findAllProductIsEnable();

    @Query("select p from Product p where p.enable = false")
    Page<Product> findAllProductIsNotEnable(Pageable pageable);

    @Query("select p from Product p where p.enable = false")
    List<Product> findAllProductIsNotEnable();

    @Query("select p from Product p where p.category.id=:catId")
    Page<Product> findAllProductByCategory(Long catId, Pageable pageable);

    @Query("select p from Product p where p.supplier.id=:supId")
    Page<Product> findAllProductBySupplier(Long supId, Pageable pageable);
}
