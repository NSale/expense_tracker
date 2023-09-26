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
    private final ProductMapper productMapper;
    private final ReceiptMapper receiptMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, ReceiptMapper receiptMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.receiptMapper = receiptMapper;
    }

    @Override
    public ProductDTO findProductById(Long id) {
        return productMapper.productToProductDto(productRepository.findById(id).get());
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
