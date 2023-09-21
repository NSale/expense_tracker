package com.lesa.Expenses.service;

import com.lesa.Expenses.domain.Receipt;

import java.util.List;

public interface ReceiptService {

    List<Receipt> getReceipts();
    Receipt getReceipt(Long id);
}
