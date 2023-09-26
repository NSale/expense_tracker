package com.lesa.Expenses.dto;

import com.lesa.Expenses.entity.Bill;

import java.time.LocalDateTime;

public record BillDTO(
        Long id,
        LocalDateTime billDate,
        Double amount,
        Bill.Type type
) {
}
