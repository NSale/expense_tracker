package com.lesa.Expenses.service;

import com.lesa.Expenses.domain.Receipt;

import java.util.List;
import java.util.Optional;

public interface ReceiptService {

    List<Receipt> getReceipts();
    Optional<Receipt> getReceipt(Long id);
    Receipt saveReceipt(Receipt receipt);
    Optional<Receipt> updateReceipt(Long receipt_id, Receipt receipt);
    void deleteReceipt(Long id);
}
