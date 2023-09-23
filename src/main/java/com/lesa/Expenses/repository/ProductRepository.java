package com.lesa.Expenses.repository;

import com.lesa.Expenses.entities.Product;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductRepository extends ListCrudRepository<Product, Long> {

    Boolean existsByName(String name);

}
