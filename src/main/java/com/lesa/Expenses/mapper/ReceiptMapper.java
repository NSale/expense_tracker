package com.lesa.Expenses.mapper;

import com.lesa.Expenses.dto.ReceiptDTO;
import com.lesa.Expenses.entity.Receipt;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReceiptMapper {

    Receipt receiptDtoToReceipt(ReceiptDTO dto);
    ReceiptDTO receiptToReceiptDto(Receipt receipt);
}
