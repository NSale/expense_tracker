package com.lesa.Expenses.mappers;

import com.lesa.Expenses.dtos.ProductDTO;
import com.lesa.Expenses.entities.Product;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product productDtoToProduct(ProductDTO dto);
    ProductDTO productToProductDto(Optional<Product> product);
}
