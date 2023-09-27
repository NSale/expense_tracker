package com.lesa.Expenses.mapper;

import com.lesa.Expenses.dto.ReceiptDTO;
import com.lesa.Expenses.entity.Receipt;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReceiptMapper {

    ReceiptMapper mapper = Mappers.getMapper(ReceiptMapper.class);
    Receipt receiptDtoToReceipt(ReceiptDTO dto);
    ReceiptDTO receiptToReceiptDto(Receipt receipt);
}
