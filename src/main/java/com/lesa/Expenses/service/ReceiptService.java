package com.lesa.Expenses.service;

import com.lesa.Expenses.dto.ReceiptDTO;
import com.lesa.Expenses.entity.Product;

import java.util.List;
import java.util.Set;

public interface ReceiptService {

    List<ReceiptDTO> getReceipts();
    ReceiptDTO getReceipt(Long id);
    ReceiptDTO saveReceipt(ReceiptDTO receipt, Set<Product> products);
    ReceiptDTO updateReceipt(Long receipt_id, ReceiptDTO receipt);
    void deleteReceipt(Long id);
}
