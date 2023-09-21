package com.lesa.Expenses.service;

import com.lesa.Expenses.domain.Receipt;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private final List<Receipt> receipts = new ArrayList<>();
    @Override
    public List<Receipt> getReceipts() {
        receipts.add(receipt);
        return receipts;
    }

    @Override
    public Receipt getReceipt(Long id) {
        return null;
    }

    Receipt receipt = new Receipt().builder()
            .shopName("Idea")
            .receiptDate(LocalDateTime.now())
            .price(2500.18)
            .currency(Receipt.Currency.DIN)
            .products(null)
            .build();
}
