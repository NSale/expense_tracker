package com.lesa.Expenses.mapper;

import com.lesa.Expenses.dto.BillDTO;
import com.lesa.Expenses.entity.Bill;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BillMapper {
    BillMapper mapper = Mappers.getMapper(BillMapper.class);
    Bill billDTOToBill(BillDTO dto);
    BillDTO billToBillDTO(Bill bill);
}
