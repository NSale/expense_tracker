package com.lesa.Expenses.dto;

import com.lesa.Expenses.entity.Product;
import com.lesa.Expenses.entity.Receipt;

public record ProductDTO(
        Long id,
        String name,
        Double quantity,
        Product.Unit unit,
        Double price,
        Receipt receipt
) {
}
