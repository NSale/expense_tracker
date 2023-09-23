package com.lesa.Expenses.repository;

import com.lesa.Expenses.entities.Receipt;
import org.springframework.data.repository.ListCrudRepository;

public interface ReceiptRepository extends ListCrudRepository<Receipt, Long> {
}
