package com.lesa.Expenses.mappers;

import com.lesa.Expenses.dtos.ProductDTO;
import com.lesa.Expenses.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product productDtoToProduct(ProductDTO dto);
    ProductDTO productToProductDto(Product product);
}
