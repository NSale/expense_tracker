package com.lesa.Expenses.repository;

import com.lesa.Expenses.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
