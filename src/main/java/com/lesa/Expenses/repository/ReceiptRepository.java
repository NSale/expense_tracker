package com.lesa.Expenses.repository;

import com.lesa.Expenses.domain.Receipt;
import org.springframework.data.repository.CrudRepository;

public interface ReceiptRepository extends CrudRepository<Receipt, Long> {
}
