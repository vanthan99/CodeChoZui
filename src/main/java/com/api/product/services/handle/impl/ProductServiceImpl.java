package com.api.product.services.handle.impl;

import com.api.product.entities.Product;
import com.api.product.repositories.CategoryRepository;
import com.api.product.repositories.ProductRepository;
import com.api.product.repositories.SupplierRepository;
import com.api.product.services.dto.ProductDTO;
import com.api.product.services.handle.ProductService;
import com.api.product.services.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;

@Component
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


//    private final CategoryRepository categoryRepository;
//    private final SupplierRepository supplierRepository;
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

    @Override
    public ProductDTO findProductById(Long id) {
        Product product = productRepository.getOne(id);
        return productMapper.toDTO(product);
    }

    @Override
    public List<ProductDTO> findAllProduct() {
        return productMapper.toDTOList(productRepository.findAll());
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        productRepository.save(product);
        return productMapper.toDTO(product);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        product.setId(id);
        productRepository.save(product);
        return productMapper.toDTO(product);
    }

    @Override
    public List<ProductDTO> findAllProductIsActive() {
        return productMapper.toDTOList(productRepository.findAllProductIsActive());
    }

    @Override
    public List<ProductDTO> findAllProductIsNotActive() {
        return productMapper.toDTOList(productRepository.findAllProductIsNotActive());
    }

    @Override
    public List<ProductDTO> findAllProductByCategory(Long catId) {
        List<Product> products = productRepository.findAllProductByCategory(catId);
        return productMapper.toDTOList(products);
    }

    @Override
    public List<ProductDTO> findAllProductBySupplier(Long supId) {
        List<Product> products = productRepository.findAllProductBySupplier(supId);
        return productMapper.toDTOList(products);
    }

    @Override
    public ProductDTO changeProductStatus(Long id) {
        Product product = productRepository.getOne(id);
        product.setEnable(!product.getEnable());
        productRepository.save(product);
        return productMapper.toDTO(product);
    }
}
