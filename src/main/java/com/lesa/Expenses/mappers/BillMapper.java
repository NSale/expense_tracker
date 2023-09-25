package com.lesa.Expenses.mappers;

import com.lesa.Expenses.dtos.BillDTO;
import com.lesa.Expenses.entities.Bill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillMapper {

    Bill billDTOToBill(BillDTO dto);
    BillDTO billToBillDTO(Bill bill);
}
