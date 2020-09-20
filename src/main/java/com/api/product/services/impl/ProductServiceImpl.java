package com.api.product.services.impl;

import com.api.product.entities.Product;
import com.api.product.repositories.ProductRepository;
import com.api.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.getOne(id);
    }

    @Override
    public Page<Product> findAllProduct(int page, int limit) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        return productRepository.findAll(pageable);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public Page<Product> findAllProductIsEnable(int limit, int page) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        return productRepository.findAllProductIsEnable(pageable);
    }

    @Override
    public Page<Product> findAllProductIsNotEnable(int limit, int page) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        return productRepository.findAllProductIsNotEnable(pageable);
    }


    @Override
    public Page<Product> findAllProductByCategory(Long catId, int limit, int page) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        return productRepository.findAllProductByCategory(catId, pageable);
    }

    @Override
    public Page<Product> findAllProductBySupplier(Long supId, int limit, int page) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        return productRepository.findAllProductBySupplier(supId, pageable);
    }

    @Override
    public Product changeProductStatus(Long id) {
        return null;
    }


//    @Autowired
//    private CategoryRepository categoryRepository;
//    @Autowired
//    private SupplierRepository supplierRepository;
//    @PostConstruct
//    public void initData(){
//        for (int i = 1 ; i <= 30 ; i++){
//            Product product = new Product();
//            product.setQuantity(new Random().nextInt(500));
//            product.setName("Sản phẩm "+i);
//            product.setDescription("Mô tả của sản phẩm "+i);
//            product.setPrice((long) new Random().nextInt(500)*1000);
//            product.setCategory(categoryRepository.getOne((long)1+new Random().nextInt(7)));
//            product.setSupplier(supplierRepository.getOne((long)1+new Random().nextInt(9)));
//            product.setEnable(new Random().nextBoolean());
//            productRepository.save(product);
//        }
//    }

}
