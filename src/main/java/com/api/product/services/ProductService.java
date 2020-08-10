package com.api.product.services;

import com.api.product.entities.Product;
import com.api.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository repo;

    @Autowired
    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> findAll(){
        return repo.findAll();
    }

    public Product findById(Long id){
        return repo.getOne(id);
    }

    public Product save(Product product){
        return repo.save(product);
    }

    public void deleteById(Long id){
        repo.deleteById(id);
    }
}
