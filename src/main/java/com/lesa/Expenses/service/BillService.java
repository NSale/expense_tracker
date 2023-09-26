package com.lesa.Expenses.service;

import com.lesa.Expenses.dto.BillDTO;

import java.util.List;

public interface BillService {

    List<BillDTO> getBills();
    BillDTO getBill(Long id);
    BillDTO saveBill(BillDTO bill);
    BillDTO updateBill(Long bill_id, BillDTO bill);
    void deleteBill(Long id);
}
