package com.lesa.Expenses.service;

import com.lesa.Expenses.dtos.ProductDTO;
import com.lesa.Expenses.dtos.ReceiptDTO;
import com.lesa.Expenses.entities.Product;
import com.lesa.Expenses.mappers.ProductMapper;
import com.lesa.Expenses.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO findProductById(Long id) {
        return productMapper.productToProductDto(productRepository.findById(id));
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void addProductToReceipt(ReceiptDTO receiptDTO, Product product) {
        receiptDTO.products().add(product);
    }
}
