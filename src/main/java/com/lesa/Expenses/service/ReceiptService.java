package com.lesa.Expenses.service;

import com.lesa.Expenses.dtos.ReceiptDTO;

import java.util.List;

public interface ReceiptService {

    List<ReceiptDTO> getReceipts();
    ReceiptDTO getReceipt(Long id);
    ReceiptDTO saveReceipt(ReceiptDTO receipt);
    ReceiptDTO updateReceipt(Long receipt_id, ReceiptDTO receipt);
    void deleteReceipt(Long id);
}
