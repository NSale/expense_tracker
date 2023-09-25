package com.lesa.Expenses.dtos;

import com.lesa.Expenses.entities.Bill;

import java.time.LocalDateTime;

public record BillDTO(
        Long id,
        LocalDateTime billDate,
        Double amount,
        Bill.Type type
) {
}
