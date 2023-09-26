package com.lesa.Expenses.mapper;

import com.lesa.Expenses.dto.ProductDTO;
import com.lesa.Expenses.entity.Product;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product productDtoToProduct(ProductDTO dto);
    ProductDTO productToProductDto(Product product);
}
