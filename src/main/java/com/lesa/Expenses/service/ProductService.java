package com.lesa.Expenses.service;

import com.lesa.Expenses.dto.ProductDTO;
import com.lesa.Expenses.dto.ReceiptDTO;
import com.lesa.Expenses.entity.Product;

public interface ProductService {

    ProductDTO findProductById(Long id);
    Product saveProduct(Product product);
}
