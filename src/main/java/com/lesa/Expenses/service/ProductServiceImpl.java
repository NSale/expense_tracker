package com.lesa.Expenses.service;

import com.lesa.Expenses.dto.ProductDTO;
import com.lesa.Expenses.entity.Product;
import com.lesa.Expenses.mapper.ProductMapper;
import com.lesa.Expenses.mapper.ReceiptMapper;
import com.lesa.Expenses.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO findProductById(Long id) {
        return ProductMapper.mapper.productToProductDto(productRepository.findById(id).get());
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
