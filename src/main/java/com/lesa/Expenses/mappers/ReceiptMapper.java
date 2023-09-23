package com.lesa.Expenses.mappers;

import com.lesa.Expenses.dtos.ReceiptDTO;
import com.lesa.Expenses.entities.Receipt;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ReceiptMapper {

    Receipt receiptDtoToReceipt(ReceiptDTO dto);
    ReceiptDTO receiptToReceiptDto(Receipt receipt);
}
