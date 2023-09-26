package com.lesa.Expenses.repository;

import com.lesa.Expenses.entity.Product;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductRepository extends ListCrudRepository<Product, Long> {

}
