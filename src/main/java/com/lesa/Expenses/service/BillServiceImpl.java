package com.lesa.Expenses.service;

import com.lesa.Expenses.dto.BillDTO;
import com.lesa.Expenses.entity.Bill;
import com.lesa.Expenses.mapper.BillMapper;
import com.lesa.Expenses.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;

    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public List<BillDTO> getBills() {
        return billRepository.findAll().stream().map(BillMapper.mapper::billToBillDTO).collect(Collectors.toList());
    }

    @Override
    public BillDTO getBill(Long id) {
        if(billRepository.findById(id).isPresent()) {
            return BillMapper.mapper.billToBillDTO(billRepository.findById(id).get());
        }
        return null;
    }

    @Override
    public BillDTO saveBill(BillDTO bill) {
        return BillMapper.mapper.billToBillDTO(billRepository.save(BillMapper.mapper.billDTOToBill(bill)));
    }

    @Override
    public BillDTO updateBill(Long bill_id, BillDTO bill) {
        if(billRepository.existsById(bill_id)) {
            Optional<Bill> existingBill = billRepository.findById(bill_id);
            existingBill.get().setBillDate(bill.billDate());
            existingBill.get().setAmount(bill.amount());
            existingBill.get().setType(bill.type());
            billRepository.save(existingBill.get());
            return BillMapper.mapper.billToBillDTO(existingBill.get());
        }
        return null;
    }

    @Override
    public void deleteBill(Long id) {
        billRepository.deleteById(id);
    }
}
