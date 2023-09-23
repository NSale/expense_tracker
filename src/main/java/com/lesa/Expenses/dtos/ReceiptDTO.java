package com.lesa.Expenses.dtos;

import com.lesa.Expenses.entities.Product;
import com.lesa.Expenses.entities.Receipt;

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
