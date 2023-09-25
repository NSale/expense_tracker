package com.lesa.Expenses.controller;

import com.lesa.Expenses.dtos.BillDTO;
import com.lesa.Expenses.service.BillService;
import org.springframework.http.HttpEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping
    public List<BillDTO> getBills() {
        return billService.getBills();
    }

    @GetMapping("{bill_id}")
    public BillDTO getBillById(@PathVariable Long bill_id) {
        return billService.getBill(bill_id);
    }

    @PostMapping()
    public HttpEntity<BillDTO> createBill(@Validated @RequestBody BillDTO bill) {
        return new HttpEntity<>(billService.saveBill(bill));
    }

    @PutMapping("{bill_id}")
    public HttpEntity<BillDTO> updateBill(@Validated @RequestBody BillDTO bill, @PathVariable Long bill_id) {
        return new HttpEntity<>(billService.updateBill(bill_id, bill));
    }

    @DeleteMapping("{bill_id}")
    public void deleteBill(@PathVariable Long bill_id) {
        billService.deleteBill(bill_id);
    }
}
