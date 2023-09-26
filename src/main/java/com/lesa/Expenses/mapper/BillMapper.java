package com.lesa.Expenses.mapper;

import com.lesa.Expenses.dto.BillDTO;
import com.lesa.Expenses.entity.Bill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillMapper {

    Bill billDTOToBill(BillDTO dto);
    BillDTO billToBillDTO(Bill bill);
}
