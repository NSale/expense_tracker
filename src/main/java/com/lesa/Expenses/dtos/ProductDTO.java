package com.lesa.Expenses.dtos;

import com.lesa.Expenses.entities.Product;
import com.lesa.Expenses.entities.Receipt;

public record ProductDTO(
        Long id,
        String name,
        Double quantity,
        Product.Unit unit,
        Double price,
        Receipt receipt
) {
}
