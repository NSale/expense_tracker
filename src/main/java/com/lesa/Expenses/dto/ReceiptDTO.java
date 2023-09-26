package com.lesa.Expenses.dto;

import com.lesa.Expenses.entity.Product;
import com.lesa.Expenses.entity.Receipt;

import java.time.LocalDateTime;
import java.util.Set;

public record ReceiptDTO(
         Long id,
         String shopName,
         LocalDateTime receiptDate,
         Double price,
         Receipt.Currency currency,
         Set<Product> products
) {
}
