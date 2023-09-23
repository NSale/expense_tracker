package com.lesa.Expenses.controller;

import com.lesa.Expenses.dtos.ReceiptDTO;
import com.lesa.Expenses.service.ReceiptService;
import org.springframework.http.HttpEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ReceiptController {

    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping
    public List<ReceiptDTO> getReceipts() {
        return receiptService.getReceipts();
    }

    @GetMapping("receipt/{receipt_id}")
    public ReceiptDTO getReceiptById(@PathVariable Long receipt_id) {
        return receiptService.getReceipt(receipt_id);
    }

    @PostMapping("receipt")
    public HttpEntity<ReceiptDTO> createReceipt(@Validated @RequestBody ReceiptDTO receipt) {
        return new HttpEntity<>(receiptService.saveReceipt(receipt));
    }

    @PutMapping("receipt/{receipt_id}")
    public HttpEntity<ReceiptDTO> updateReceipt(@Validated @RequestBody ReceiptDTO receipt, @PathVariable Long receipt_id) {
        return new HttpEntity<>(receiptService.updateReceipt(receipt_id, receipt));
    }

    @DeleteMapping("receipt/{receipt_id}")
    public void deleteReceipt(@PathVariable Long receipt_id) {
        receiptService.deleteReceipt(receipt_id);
    }
}
