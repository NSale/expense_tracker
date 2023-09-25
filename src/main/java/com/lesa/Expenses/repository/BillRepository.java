package com.lesa.Expenses.repository;

import com.lesa.Expenses.entities.Bill;
import org.springframework.data.repository.ListCrudRepository;

public interface BillRepository extends ListCrudRepository<Bill, Long> {
}
