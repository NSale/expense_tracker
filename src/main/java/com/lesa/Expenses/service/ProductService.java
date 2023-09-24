package com.lesa.Expenses.service;

import com.lesa.Expenses.dtos.ProductDTO;
import com.lesa.Expenses.dtos.ReceiptDTO;
import com.lesa.Expenses.entities.Product;

public interface ProductService {

    ProductDTO findProductById(Long id);
    void saveProduct(Product product);
    void addProductToReceipt(ReceiptDTO receiptDTO, Product product);
}
