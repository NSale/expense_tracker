package com.lesa.Expenses.mapper;

import com.lesa.Expenses.dto.ProductDTO;
import com.lesa.Expenses.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface ProductMapper {

    ProductMapper mapper = Mappers.getMapper(ProductMapper.class);
    Product productDtoToProduct(ProductDTO dto);
    ProductDTO productToProductDto(Product product);
}
