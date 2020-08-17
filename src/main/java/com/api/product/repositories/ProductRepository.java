package com.api.product.repositories;

import com.api.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("select p from Product p where p.enable = true")
    List<Product> findAllProductIsActive();

    @Query("select p from Product p where p.enable = false")
    List<Product> findAllProductIsNotActive();

    @Query("select p from Product p where p.category.id=:catId")
    List<Product> findAllProductByCategory(Long catId);

    @Query("select p from Product p where p.supplier.id=:supId")
    List<Product> findAllProductBySupplier(Long supId);
}
